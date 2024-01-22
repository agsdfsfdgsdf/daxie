package com.deyi.daxie.cloud.service.websocket;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deyi.daxie.cloud.service.config.HttpConfig;
import com.deyi.daxie.cloud.service.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.util.Map;
import java.util.Objects;
import javax.websocket.*;

@Slf4j
@Component
@ClientEndpoint
public class WebSocketClient {
    private static final String TCS_WEBSOCKET_SERVER = "ws://" + HttpConfig.TCS_BASE_URL + "/websocket/auditSocket/ws";

    private String truckNo;
    public Session session_cloud_tcs; // 与TCS-websocket建立连接的session

    public WebSocketClient initClient(String truckNo, String token) {
        try {
            WebSocketContainer webSocketContainer = ContainerProvider.getWebSocketContainer();
            webSocketContainer.setDefaultMaxSessionIdleTimeout(0); // 无限超时
            WebSocketClient wsClient = new WebSocketClient();
            wsClient.setTruckNo(truckNo);
            webSocketContainer.connectToServer(wsClient, new URI(TCS_WEBSOCKET_SERVER + "?token=" + token));
            log.info("initClient: " + TCS_WEBSOCKET_SERVER + "?token=" + token);
            return wsClient;
        } catch (Exception e) {
            log.error("WebSocketClient initClient error: " + e.getMessage());
        }
        return null;
    }

    public void setTruckNo(String truckNo) {
        this.truckNo = truckNo;
    }

    @OnOpen
    public void onOpen(Session session) {
        log.info("dell-WebSocketClient connect with TCS-websocket-server, session.getId(): "
                + session.getId() + ",truckNo: " + truckNo);
        this.session_cloud_tcs = session;
        this.session_cloud_tcs.setMaxIdleTimeout(0); // 无限超时
        this.session_cloud_tcs.setMaxTextMessageBufferSize(256 * 1024 * 1024); // 100M
        this.session_cloud_tcs.setMaxBinaryMessageBufferSize(256 * 1024 * 1024); // 100M
    }

    @OnMessage
    public void onMessage(String message) {
        try {
            // 解析数据
            JSONObject tcsWsResponse = JSON.parseObject(message);

            String receiver = tcsWsResponse.getString("Receiver");
            String messageType = tcsWsResponse.getString("MessageType");
            // 判断接收对象
            if (!Objects.equals(receiver, "ALL") && !Objects.equals(receiver, this.truckNo)) {
                return;
            }
            // 查找车端与TCS连接的session
            for (Map.Entry<String, Session> entry : WebSocketServer.SESSION_MAP.entrySet()) {
                String truckNo = StringUtils.split(entry.getKey(), "+")[0];
                Session session = entry.getValue();
                if (Objects.equals(this.truckNo, truckNo) && session.isOpen()) {
                    synchronized (session) {
                        session.getBasicRemote().sendText(Result.toString(Result.success(messageType, tcsWsResponse)));
                        log.info("TCS-WebSocketClient onMessage, send message to truck(" + truckNo + "): " + Result.toString(Result.success(messageType, tcsWsResponse)));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // 显示完整报错信息，上线后删除
            log.error("dell-WebSocketClient onMessage error: " + e.getMessage());
        }
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        log.info("dell-WebSocketClient onClose, session.getId(): " + session.getId() + ", truckNo: " + truckNo);
        // 连接断开时发送消息给客户端

        WebSocketServer.TCS_CLIENT_MAP.remove(truckNo);
    }

    /**
     * 断开与TCS-websocket的连接
     */
    public void closeTcsWebsocket() {
        log.info("dell-WebSocketClient closeTcsWebsocket");
        try {
            if (session_cloud_tcs.isOpen()) {
                session_cloud_tcs.close(new CloseReason(CloseReason.CloseCodes.NORMAL_CLOSURE, "Connection closed"));
                log.info("WebSocketClient onClose executed");
            }
        } catch (IOException e) {
            log.error("closeTcsWebsocket: " + e.getMessage());
        }
    }

    /**
     * 断开连接
     *
     * @param session session
     * @param e       e
     */
    @OnError
    public void onError(Session session, Throwable e) {
        log.error("dell-WebSocketClient连接TCS-websocket-server错误, truckNo: " + this.truckNo, e);
        log.error("dell-WebSocketClient连接TCS-websocket-server错误, session.getId(): " + session.getId());
    }

    public void sendMsg(String message) {
        session_cloud_tcs.getAsyncRemote().sendText(message);
    }

}

