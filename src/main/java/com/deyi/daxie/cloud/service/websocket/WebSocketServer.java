package com.deyi.daxie.cloud.service.websocket;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deyi.daxie.cloud.service.bean.VelStatusData;
import com.deyi.daxie.cloud.service.listener.LessonMsgService;
import com.deyi.daxie.cloud.service.listener.WSListener;
import com.deyi.daxie.cloud.service.mapper.VelStatusDataMapper;
import com.deyi.daxie.cloud.service.redis.RedisUtil;
import com.deyi.daxie.cloud.service.util.Constant;
import com.deyi.daxie.cloud.service.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Component
@ServerEndpoint(value = "/websocket/dispatch/{truckNo}")
public class WebSocketServer {

    private ScheduledExecutorService heartbeatScheduler;
    private static RedisUtil redisUtil;
    private static final AtomicInteger ONLINE_COUNT = new AtomicInteger(0);
    //声明线程池，大小为30
    private static ExecutorService executorService = Executors.newCachedThreadPool();

    private static LessonMsgService lessonMsgService;

    //private static VelStatusDataMapper velStatusDataMapper;

    @Autowired
    public void setLessonMsgService(LessonMsgService lessonMsgService) {
        WebSocketServer.lessonMsgService = lessonMsgService;
    }
    /*@Autowired
    public void setVelStatusDataMapper(VelStatusDataMapper velStatusDataMapper) {
        WebSocketServer.velStatusDataMapper = velStatusDataMapper;
    }*/

    // 车-云 session
    //public static final Map<String, Session> SESSION_MAP = new HashMap<>();
    public static final Map<String, Session> SESSION_MAP = new ConcurrentHashMap<>();
    // 车-云-TCS client
    public static final Map<String, WebSocketClient> TCS_CLIENT_MAP = new ConcurrentHashMap<>();
   // public static final Map<String, WebSocketClient> TCS_CLIENT_MAP = new HashMap<>();
    @Autowired
    public void setRedisUtil(RedisUtil redisUtil) {
        WebSocketServer.redisUtil = redisUtil;
    }

    @PostConstruct
    public void init() {
        log.info("webSocket start...");
    }

    /**
     * 连接建立成功调用的方法
     *
     * @param session session
     */
    @OnOpen
    public void onOpen(@PathParam("truckNo") String truckNo, Session session) {
        // 如何集卡号为空，主动关闭连接
        if (StringUtils.isEmpty(truckNo)) {
            optClose(session);
            return;
        }
        session.setMaxIdleTimeout(0); // 无限超时
        session.setMaxTextMessageBufferSize(100 * 1024 * 1024); // 100M
        session.setMaxBinaryMessageBufferSize(100 * 1024 * 1024); // 100M
        SESSION_MAP.put(truckNo + "+" + session.getId(), session);
        // 启动心跳定时任务
        startHeartbeat(session);
    }

    /**
     * 操作进行下线
     *
     * @param session session
     */
    public void optClose(Session session) {
        log.info("optClose session.getId(): " + session.getId());
        // 判断当前连接是否还在线
        if (session.isOpen()) {
            try {
                // 关闭连接
                CloseReason closeReason = new CloseReason(CloseReason.CloseCodes.NORMAL_CLOSURE, "truck_no缺失");
                session.close(closeReason);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 连接关闭调用的方法
     *
     * @param session session
     */
    @OnClose
    public void onClose(Session session) {
        log.info("WebSocketServer onClose " + session.getId());
        // 关闭连接时停止心跳定时任务
        stopHeartbeat();
        // 车辆与dell断开连接后，删除map中的session
        for (Map.Entry<String, Session> entry : SESSION_MAP.entrySet()) {
            String key = entry.getKey();
            String truckNo = StringUtils.split(key, "+")[0];
            Session value = entry.getValue();
            if (Objects.equals(session.getId(), value.getId())) {
                SESSION_MAP.remove(key);
                log.info("SESSION_MAP.remove: " + key);
                // 删除redis中车辆登录状态
                // 将redis中的token删除
                redisUtil.hdel(truckNo, Constant.REDIS_ITEM_TOKEN);
                // 将redis中的在线状态删除
                redisUtil.hdel(truckNo, Constant.REDIS_ITEM_ONLINE);
            }
        }
        int cnt = ONLINE_COUNT.decrementAndGet();
        log.info("have link close，link count:" + cnt);
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message message
     * @param session session
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("dell-server have new message from client(truck): " + message);
        WSListener w = new WSListener();
        Result result = w.initWSListener(message);
        //lessonMsgService.save(message);
        executorService.submit(() -> lessonMsgService.save(message));
        if (session != null && session.isOpen()) {
            synchronized (session) {
                try {
                    /*JSONObject obj = JSON.parseObject(message);
                    String truckNo = obj.getString("truckNo");
                    log.info("-----{}",truckNo);
                    VelStatusData velStatusData = velStatusDataMapper.queryByDevice(truckNo);
                    log.info("======{}",velStatusData);*/
                    session.getBasicRemote().sendText(Result.toString(result));
                    log.info("dell-server send the message to client(truck)：" + Result.toString(result));
                } catch (IOException e) {
                    log.error("dell-server onMessage IOException: " + e.getMessage());
                }
            }
        }
    }

    /**
     * 出现错误调用
     *
     * @param session session
     * @param error   error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        if (session != null) {
            log.error("error Session ID:" + session.getId() + "\n" + error.getMessage());
            log.error("error Session ID:" + session.getId() + "\n" + error.getCause().getMessage());
        }
    }

    /**
     * 发送消息
     *
     * @param session session
     * @param message message
     */
    public static void sendMessage(Session session, String message) {
        session.getAsyncRemote().sendText(message);
    }

    /**
     * 全部广播发送
     *
     * @param message message
     */
    public static void broadCastInfo(String message) {
        for (Map.Entry<String, Session> entry : SESSION_MAP.entrySet()) {
            Session value = entry.getValue();
            if (value.isOpen()) {
                value.getAsyncRemote().sendText(message);
            }
        }
    }

    /**
     * 单个发送
     *
     * @param message   message
     * @param sessionId sessionId
     */
    public static void sendMessage(String message, String sessionId) {
        Session session = null;
        for (Map.Entry<String, Session> entry : SESSION_MAP.entrySet()) {
            Session value = entry.getValue();
            if (Objects.equals(sessionId, value.getId())) {
                session = value;
                break;
            }
        }
        if (session != null) {
            session.getAsyncRemote().sendText(message);
        } else {
            log.info("Can`t find appoint id:" + sessionId);
        }
    }
    private void startHeartbeat(Session session) {
        heartbeatScheduler = Executors.newSingleThreadScheduledExecutor();
        heartbeatScheduler.scheduleAtFixedRate(() -> sendHeartbeat(session), 10, 10, TimeUnit.SECONDS);
    }
    private void sendHeartbeat(Session session) {
        try {
            JSONObject response = new JSONObject();
            response.put("code", Constant.TCS_SUCCESS);
            Result result =new Result(200,"getTcsWebsoketstate", response);
            session.getBasicRemote().sendText(Result.toString(result));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void stopHeartbeat() {
        if (heartbeatScheduler != null) {
            heartbeatScheduler.shutdownNow();
        }
    }
}
