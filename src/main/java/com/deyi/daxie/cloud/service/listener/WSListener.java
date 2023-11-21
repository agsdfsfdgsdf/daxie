package com.deyi.daxie.cloud.service.listener;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deyi.daxie.cloud.service.bean.*;
import com.deyi.daxie.cloud.service.email.EmailService;
import com.deyi.daxie.cloud.service.http.SplunkHttpApi;
import com.deyi.daxie.cloud.service.http.TCSHttpApi;
import com.deyi.daxie.cloud.service.mapper.*;
import com.deyi.daxie.cloud.service.redis.RedisUtil;
import com.deyi.daxie.cloud.service.util.Constant;
import com.deyi.daxie.cloud.service.util.Result;
import com.deyi.daxie.cloud.service.websocket.WebSocketClient;
import com.deyi.daxie.cloud.service.websocket.WebSocketServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.CloseReason;
import javax.websocket.Session;
import java.io.IOException;
import java.util.*;

import static com.deyi.daxie.cloud.service.websocket.WebSocketServer.SESSION_MAP;

@Slf4j
@Component
public class WSListener {
    private static RedisUtil redisUtil;
    private static TCSHttpApi tcsHttpApi;
    private static SplunkHttpApi splunkHttpApi;
    private static VelStatusDataMapper velStatusDataMapper;
    private static VelControlDataMapper velControlDataMapper;
    private static VelMissionDataMapper velMissionDataMapper;
    private static VelWarnDataMapper velWarnDataMapper;
    private static VelAligningDataMapper velAligningDataMapper;
    private static VelObstacleDataMapper velObstacleDataMapper;

    private static TcsLoginMapper tcsLoginMapper;
    private static TcsLogoutMapper tcsLogoutMapper;

    private static EmailService emailService;

    private static TcsApiLockarriveMapper tcsApiLockarriveMapper;

    @Autowired
    public void setRedisUtil(RedisUtil redisUtil) {
        WSListener.redisUtil = redisUtil;
    }

    @Autowired
    public void setHttpApi(TCSHttpApi TCSHttpApi) {
        WSListener.tcsHttpApi = TCSHttpApi;
    }

    @Autowired
    public void setSplunkHttpApi(SplunkHttpApi splunkHttpApi) {
        WSListener.splunkHttpApi = splunkHttpApi;
    }

    @Autowired
    public void setEmailService(EmailService emailService) {
        WSListener.emailService = emailService;
    }

    @Autowired
    public void setStatusDataService(VelStatusDataMapper velStatusDataMapper) {
        WSListener.velStatusDataMapper = velStatusDataMapper;
    }

    @Autowired
    public void setControlDataService(VelControlDataMapper velControlDataMapper) {
        WSListener.velControlDataMapper = velControlDataMapper;
    }

    @Autowired
    public void setMissionDataService(VelMissionDataMapper velMissionDataMapper) {
        WSListener.velMissionDataMapper = velMissionDataMapper;
    }

    @Autowired
    public void setWarningDataService(VelWarnDataMapper velWarnDataMapper) {
        WSListener.velWarnDataMapper = velWarnDataMapper;
    }

    @Autowired
    public void setAligningDataService(VelAligningDataMapper velAligningDataMapper) {
        WSListener.velAligningDataMapper = velAligningDataMapper;
    }

    @Autowired
    public void setVelObstacleDataService(VelObstacleDataMapper velObstacleDataMapper) {
        WSListener.velObstacleDataMapper = velObstacleDataMapper;
    }

    @Autowired
    public void setTcsApiActionService(TcsApiLockarriveMapper tcsApiLockarriveMapper) {
        WSListener.tcsApiLockarriveMapper = tcsApiLockarriveMapper;
    }
    @Autowired
    public void setTcsLoginMapperService(TcsLoginMapper tcsLoginMapper) {
        WSListener.tcsLoginMapper = tcsLoginMapper;
    }

    @Autowired
    public void setTcsLogoutMapperService(TcsLogoutMapper tcsLogoutMapper) {
        WSListener.tcsLogoutMapper = tcsLogoutMapper;
    }

    /**
     * 接收车端websocket数据
     *
     * @param msg msg
     * @return Result
     */
    public Result initWSListener(String msg) {
        try {
            JSONObject obj = JSON.parseObject(msg);
            MessageType type = MessageType.getByValue(obj.getString("messageType"));
            if (type == null) {
                return new Result(Constant.HTTP_ERROR, "Invalid request, data type does not exist");
            }
            switch (Objects.requireNonNull(type)) {
                case LOGIN:
                    return login(obj);
                case LOGIN_OUT:
                    return logout(obj);
                case ALIVE:
                    return alive(obj);
                case SET_TRUCK_STATUS:
                    return uploadTruckStatus(obj);
                case GET_LED_MSG:
                    return getLedMessage(obj);
                case GET_LAST_ORDER:
                    return getInstructions(obj);
                case QC_INFO:
                case QD_CPS_INFO:
                case GET_QC_INFO:
                case RTG_MOVE_STATUS:
                    return focusChannel(obj);
                case GET_YQ:
                    return getYqInfo(obj);
                case LI_HUO:
                    return uploadTruckLiHuo(obj);
                case TCS_QC_POSITION:
                    return tcsQcPosition(obj);
                case GET_LANE:
                    return getQdLaneInfo(obj);
                case GET_GPS:
                    return getQdGpsAll(obj);
                case SEND_PROMPT:
                    return sendNotice(obj);
                case CONFIRM_QC_CPS_END:
                    return confirmQcCpsEnd(obj);
                case TCS_RTG_TRUCK:
                    return tcsRtgTruck(obj);
                case GET_CHANGE_ROAD:
                    return changeRoad(obj);
                case TCS_RTG_POSITION:
                    return uploadPosition(obj);
                case RTG_INPLACE:
                    return confirmCpsStop(obj);
                case GET_LONG_MEN_DIAO_GPS:
                    return getLmdGpsAll(obj);
                case GET_DUI_GAO_JI_GPS:
                    return getLjGpsAll(obj);
                case LOCK_ARRIVE:
                    return lockArrive(obj);
                case GET_ONLINE_STATUS:
                    return getOnlineStatus(obj);
                case GET_JK_GPS_ALL:
                    return getJkGpsAll(obj);
                case GET_TRUCK_UNLOCK:
                    return getTruckUnlock(obj);


                case STATUS_DATA:
                    return statusDataAdd(obj.getJSONObject("data"));
                case MISSION_DATA:
                    return missionDataAdd(obj.getJSONObject("data"));
                case CONTROL_DATA:
                    return controlDataAdd(obj.getJSONObject("data"));
                case WARN_DATA:
                    return warningDataAdd(obj.getJSONObject("data"));
                case ALIGNING_DATA:
                    return aligningDataAdd(obj.getJSONObject("data"));
                case OBSTACLE_DATA:
                    return obstacleDataAdd(obj.getJSONObject("data"));
                default:
                    return new Result(Constant.HTTP_INVALID, "Invalid request");
            }
        } catch (Exception e) {
            return new Result(Constant.HTTP_ERROR, "Invalid request, " + e.getMessage());
        }
    }

    /**
     * 获取token
     *
     * @param truckNo truckNo
     * @return String
     */
    private String getToken(String truckNo) {
        String token;
        token = (String) redisUtil.hget(truckNo, Constant.REDIS_ITEM_TOKEN);
        return token;
    }

    /**
     * 通用应发to车辆
     *
     * @param messageType messageType
     * @param response    response
     * @return Result
     */
    private Result commonToVel(String messageType, JSONObject response) {
        // TCS应答失败
        if (!Objects.equals(response.getString("code"), Constant.TCS_SUCCESS)) {
            return Result.error(messageType, response);
        }
        return Result.success(messageType, response);
    }

    /**
     * 3.1.1.用户登录
     *
     * @param obj obj
     * @return Result
     */
    public Result login(JSONObject obj) {
        log.info("用户登录obj{}", obj.toString());
        String truckNo = obj.getJSONObject("data").getString("username");
        // 判断车辆是否已登录，如果已登录不重复登录dell
        if (redisUtil.hHasKey(truckNo, Constant.REDIS_ITEM_ONLINE)) {
            JSONObject response = new JSONObject();
            response.put("code", Constant.TCS_SUCCESS);
            // 发送登录成功应答
            return Result.success(obj.getString("messageType"), response);
        }

        // 请求TCS获取token
        JSONObject response = tcsHttpApi.login(getToken(obj.getString("truckNo")), obj.getJSONObject("data"));
        String token = response.getString("data");

        // 将token保存入redis
        redisUtil.hset(truckNo, Constant.REDIS_ITEM_TOKEN, token, 24 * 60 * 60);

        // 与TCS-websocket建立连接
        WebSocketClient socketClient = new WebSocketClient();
        socketClient = socketClient.initClient(truckNo, token);
        WebSocketServer.TCS_CLIENT_MAP.put(truckNo, socketClient);

        log.info("login socketClient.session_cloud_tcs.getId() == " + socketClient.session_cloud_tcs.getId());

        // 将车辆上线状态保存入redis
        redisUtil.hset(truckNo, Constant.REDIS_ITEM_ONLINE, true, 24 * 60 * 60);
        TcsLogin tcsLogin = new TcsLogin();
        tcsLogin.setTime(new Date());
        tcsLogin.setParamUsername(obj.getString("username"));
        tcsLogin.setParamPassword(obj.getString("password"));
        tcsLogin.setResData(response.getString("data"));
        tcsLogin.setResCode(response.getString("code"));
        tcsLogin.setTruckNo(truckNo);
        tcsLogin.setResMessage(obj.getString("messageType"));
        tcsLoginMapper.add(tcsLogin);
        // 发送登录成功应答
        return Result.success(obj.getString("messageType"), response);
    }

    /**
     * 3.1.2.用户退出
     *
     * @param obj obj
     * @return Result
     */
    public Result logout(JSONObject obj) {
        String truckNo = obj.getJSONObject("data").getString("username");
        WebSocketClient socketClient = WebSocketServer.TCS_CLIENT_MAP.get(truckNo);
        JSONObject response = tcsHttpApi.logout(getToken(obj.getString("truckNo")), obj.getJSONObject("data"));
        // TCS应答失败
        if (!Objects.equals(response.getString("code"), Constant.TCS_SUCCESS)) {
            log.info("logout response code is not 200");
            return Result.error(obj.getString("messageType"), response);
        }

        try {
            // 与TCS-websocket关闭连接
            socketClient.closeTcsWebsocket();
        } catch (Exception e) {
            log.error("logout, e.getMessage() == " + e.getMessage());
        }

        // 将redis中的token删除
        redisUtil.hdel(truckNo, Constant.REDIS_ITEM_TOKEN);
        // 将redis中的在线状态删除
        redisUtil.hdel(truckNo, Constant.REDIS_ITEM_ONLINE);

        // 主动断开车端与云端的链接
        for (Map.Entry<String, Session> entry : SESSION_MAP.entrySet()) {
            String key = entry.getKey();
            Session session = entry.getValue();
            if (key.contains(truckNo) && session.isOpen()) {
                Timer timer = new Timer();
                TimerTask timerTask = new TimerTask() {
                    @Override
                    public void run() {
                        log.info("delay 1 session.close");
                        CloseReason closeReason = new CloseReason(CloseReason.CloseCodes.NORMAL_CLOSURE, "断开与TCS的连接");
                        try {
                            session.close(closeReason);
                        } catch (IOException e) {
                            log.error(e.getMessage());
                            throw new RuntimeException(e);
                        }
                    }
                };
                timer.schedule(timerTask, 1000);
            }
        }
        TcsLogout tcsLogout = new TcsLogout();
        tcsLogout.setTime(new Date());
        tcsLogout.setResCode(response.getString("code"));
        tcsLogout.setParamPassword(obj.getString("password"));
        tcsLogout.setParamUsername(obj.getString("username"));
        tcsLogout.setTruckNo(truckNo);
        tcsLogout.setResMessage(obj.getString("messageType"));
        tcsLogout.setToken(getToken(truckNo));
        tcsLogout.setResData(response.getString("data"));
        tcsLogoutMapper.add(tcsLogout);
        return Result.success(obj.getString("messageType"), response);
    }

    /**
     * 3.1.3.上传心跳
     *
     * @param obj obj
     * @return Result
     */
    public Result alive(JSONObject obj) {
        JSONObject response = tcsHttpApi.alive(getToken(obj.getString("truckNo")), obj.getJSONObject("data"));

        return commonToVel(obj.getString("messageType"), response);
    }

    /**
     * 3.1.4.上传集卡状态-TCS
     *
     * @param obj obj
     * @return Result
     */
    public Result uploadTruckStatus(JSONObject obj) {
        JSONObject response = tcsHttpApi.uploadTruckStatus(getToken(obj.getString("truckNo")), obj.getJSONObject("data"));

        return commonToVel(obj.getString("messageType"), response);
    }

    /**
     * 3.1.5.获取LED显示的内容
     *
     * @param obj obj
     * @return Result
     */
    public Result getLedMessage(JSONObject obj) {

        JSONObject response = tcsHttpApi.getLedMessage(getToken(obj.getString("truckNo")), obj.getJSONObject("data"));

        return commonToVel(obj.getString("messageType"), response);
    }

    /**
     * 3.1.6.查询最新的指令信息
     *
     * @param obj obj
     * @return Result
     */
    public Result getInstructions(JSONObject obj) {

        JSONObject response = tcsHttpApi.getInstructions(getToken(obj.getString("truckNo")), obj.getJSONObject("data"));

        return commonToVel(obj.getString("messageType"), response);
    }

    /**
     * 3.1.7.业务信息订阅
     *
     * @param obj obj
     * @return Result
     */
    public Result focusChannel(JSONObject obj) {
        JSONObject response = tcsHttpApi.focusChannel(getToken(obj.getString("truckNo")), obj.getJSONObject("data"));

        return commonToVel(obj.getString("messageType"), response);
    }

    /**
     * 3.2.1.获取上下引桥数据
     *
     * @param obj obj
     * @return Result
     */
    public Result getYqInfo(JSONObject obj) {
        JSONObject response = tcsHttpApi.getYqInfo(getToken(obj.getString("truckNo")), obj.getJSONObject("data"));

        return commonToVel(obj.getString("messageType"), response);
    }

    /**
     * 3.2.2.理货上报车号功能
     *
     * @param obj obj
     * @return Result
     */
    public Result uploadTruckLiHuo(JSONObject obj) {
        JSONObject response = tcsHttpApi.uploadTruckLiHuo(getToken(obj.getString("truckNo")), obj.getJSONObject("data"));

        return commonToVel(obj.getString("messageType"), response);
    }

    /**
     * 3.2.3.桥吊下集卡到位
     *
     * @param obj obj
     * @return Result
     */
    public Result tcsQcPosition(JSONObject obj) {
        log.info("桥吊下集卡到位obj{}", obj.toString());
        JSONObject response = tcsHttpApi.tcsQcPosition(getToken(obj.getString("truckNo")), obj.getJSONObject("data"));
        log.info("桥吊下集卡到位truckNo{},response{}",getToken(obj.getString("truckNo")), response.toString());

        return commonToVel(obj.getString("messageType"), response);
    }

    /**
     * 3.2.4.获取桥吊作业车道数据
     *
     * @param obj obj
     * @return Result
     */
    public Result getQdLaneInfo(JSONObject obj) {
        JSONObject response = tcsHttpApi.getQdLaneInfo(getToken(obj.getString("truckNo")));

        return commonToVel(obj.getString("messageType"), response);
    }

    /**
     * 3.2.5.获取所有桥吊GPS数据
     *
     * @param obj obj
     * @return Result
     */
    public Result getQdGpsAll(JSONObject obj) {

        JSONObject response = tcsHttpApi.getQdGpsAll(getToken(obj.getString("truckNo")));

        return commonToVel(obj.getString("messageType"), response);
    }

    /**
     * 3.2.6.发送提示信息至桥吊
     *
     * @param obj obj
     * @return Result
     */
    public Result sendNotice(JSONObject obj) {
        JSONObject response = tcsHttpApi.sendNotice(getToken(obj.getString("truckNo")), obj.getJSONObject("data"));

        return commonToVel(obj.getString("messageType"), response);
    }

    /**
     * 3.2.7.无人集卡桥吊下对位完成信息
     *
     * @param obj obj
     * @return Result
     */
    public Result confirmQcCpsEnd(JSONObject obj) {
        JSONObject response = tcsHttpApi.confirmQcCpsEnd(getToken(obj.getString("truckNo")), obj.getJSONObject("data"));

        return commonToVel(obj.getString("messageType"), response);
    }

    /**
     * 3.3.1.无人集卡进出栏申请
     *
     * @param obj obj
     * @return Result
     */
    public Result tcsRtgTruck(JSONObject obj) {
        JSONObject response = tcsHttpApi.tcsRtgTruck(getToken(obj.getString("truckNo")), obj.getJSONObject("data"));

        return commonToVel(obj.getString("messageType"), response);
    }

    /**
     * 3.3.2.无人集卡堆场内借道申请
     *
     * @param obj obj
     * @return Result
     */
    public Result changeRoad(JSONObject obj) {
        JSONObject response = tcsHttpApi.changeRoad(getToken(obj.getString("truckNo")), obj.getJSONObject("data"));

        return commonToVel(obj.getString("messageType"), response);
    }

    /**
     * 3.3.3.无人集卡堆场内到位上报
     *
     * @param obj obj
     * @return Result
     */
    public Result uploadPosition(JSONObject obj) {
        JSONObject response = tcsHttpApi.uploadPosition(getToken(obj.getString("truckNo")), obj.getJSONObject("data"));

        return commonToVel(obj.getString("messageType"), response);
    }

    /**
     * 3.3.4.无人集卡堆场内接收对位信息完成
     *
     * @param obj obj
     * @return Result
     */
    public Result confirmCpsStop(JSONObject obj) {
        JSONObject response = tcsHttpApi.confirmCpsStop(getToken(obj.getString("truckNo")), obj.getJSONObject("data"));

        return commonToVel(obj.getString("messageType"), response);
    }

    /**
     * 3.3.5.获取所有龙门吊GPS数据
     *
     * @param obj obj
     * @return Result
     */
    public Result getLmdGpsAll(JSONObject obj) {
        JSONObject response = tcsHttpApi.getLmdGpsAll(getToken(obj.getString("truckNo")));

        return commonToVel(obj.getString("messageType"), response);
    }

    /**
     * 3.3.5.获取所有龙门吊GPS数据
     *
     * @param obj obj
     * @return Result
     */
    public Result getLjGpsAll(JSONObject obj) {
        JSONObject response = tcsHttpApi.getLjGpsAll(getToken(obj.getString("truckNo")));

        return commonToVel(obj.getString("messageType"), response);
    }

    /**
     * 4.12.装卸锁对接
     *
     * @param obj obj
     * @return Result
     */
    public Result lockArrive(JSONObject obj) {
        // 请求TCS
        JSONObject response = tcsHttpApi.lockArrive(getToken(obj.getString("truckNo")), obj.getJSONObject("data"));
        return commonToVel(obj.getString("messageType"), response);
    }

    /**
     * 3.1.8.查询TOS集卡在线状态
     *
     * @param obj obj
     * @return Result
     */
    public Result getOnlineStatus(JSONObject obj) {
        // 请求TCS
        JSONObject response = tcsHttpApi.getOnlineStatus(getToken(obj.getString("truckNo")), obj.getJSONObject("data"));
        return commonToVel(obj.getString("messageType"), response);
    }

    /**
     * 3.1.9.获取集卡GPS数据
     *
     * @param obj obj
     * @return Result
     */
    public Result getJkGpsAll(JSONObject obj) {
        // 请求TCS
        JSONObject response = tcsHttpApi.getJkGpsAll(getToken(obj.getString("truckNo")), obj.getJSONObject("data"));
        return commonToVel(obj.getString("messageType"), response);
    }

    /**
     * 3.3.10. 查询集卡是否需要装卸锁
     *
     * @param obj obj
     * @return Result
     */
    public Result getTruckUnlock(JSONObject obj) {
        // 请求TCS
        JSONObject response = tcsHttpApi.getTruckUnlock(getToken(obj.getString("truckNo")), obj.getJSONObject("data"));
        return commonToVel(obj.getString("messageType"), response);
    }

    /**
     * 状态数据上传
     *
     * @param msg msg
     * @return Result
     */
    public Result statusDataAdd(JSONObject msg) {
        // 发送至Splunk系统
        new Thread(() -> splunkHttpApi.uploadStatusData(msg)).start();
        // 保存至本地数据库
        VelStatusData velStatus = new VelStatusData();
        velStatus.setDeviceNum(msg.getString("device_num"));
        velStatus.setFleet(msg.getString("fleet"));
        velStatus.setEnergy(msg.getString("energy"));
        velStatus.setLoginStatus(msg.getIntValue("login_status"));
        velStatus.setOperationMode(msg.getIntValue("operation_mode"));
        velStatus.setVersion(msg.getString("version"));
        velStatus.setDeviceTime(msg.getString("device_time"));
        int count = WSListener.velStatusDataMapper.add(velStatus);
        if (count > 0) {
            return Result.success();
        }
        return Result.error();
    }

    /**
     * 控制数据上传
     *
     * @param msg msg
     * @return Result
     */
    public Result controlDataAdd(JSONObject msg) {
        // 发送至Splunk系统
        new Thread(() -> splunkHttpApi.uploadControlData(msg)).start();
        // 保存至本地数据库
        VelControlData velControlData = new VelControlData();
        velControlData.setDeviceNum(msg.getString("device_num"));
        velControlData.setLongitudeR(msg.getDouble("longitude_r"));
        velControlData.setLatitudeR(msg.getDouble("latitude_r"));
        velControlData.setLongitudeD(msg.getDouble("longitude_d"));
        velControlData.setLatitudeD(msg.getDouble("latitude_d"));
        velControlData.setSpeedR(msg.getDouble("speed_r"));
        velControlData.setSpeedD(msg.getIntValue("speed_d"));
        velControlData.setSpeedL(msg.getIntValue("speed_l"));
        velControlData.setThrottleR(msg.getDouble("throttle_r"));
        velControlData.setThrottleD(msg.getDouble("throttle_d"));
        velControlData.setThrottleS(msg.getDouble("throttle_s"));
        velControlData.setBrakeR(msg.getDouble("brake_r"));
        velControlData.setBrakeD(msg.getDouble("brake_d"));
        velControlData.setBrakeS(msg.getDouble("brake_s"));
        velControlData.setWheelR(msg.getDouble("wheel_r"));
        velControlData.setWheelD(msg.getDouble("wheel_d"));
        velControlData.setWheelS(msg.getDouble("wheel_s"));
        velControlData.setGearR(msg.getString("gear_r"));
        velControlData.setGearD(msg.getString("gear_d"));
        velControlData.setLightR(msg.getString("light_r"));
        velControlData.setLightD(msg.getString("light_d"));
        velControlData.setIsCp(msg.getIntValue("is_cp"));
        velControlData.setCpStart(msg.getIntValue("cp_start"));
        velControlData.setCpEnd(msg.getIntValue("cp_end"));
        velControlData.setDeviceTime(msg.getString("device_time"));
        velControlData.setPosition(msg.getIntValue("position"));
        velControlData.setDevDistance(msg.getIntValue("dev_distance"));
        int count = WSListener.velControlDataMapper.add(velControlData);
        if (count > 0) {
            return Result.success();
        }
        return Result.error();
    }

    /**
     * 任务数据上传
     *
     * @param msg msg
     * @return Result
     */
    public Result missionDataAdd(JSONObject msg) {
        // 发送至Splunk系统
        new Thread(() -> splunkHttpApi.uploadMissionData(msg)).start();
        // 保存至本地数据库
        VelMissionData velMissionData = new VelMissionData();
        velMissionData.setContainerDev(msg.getDoubleValue("container_dev"));
        velMissionData.setReceivungTime(msg.getString("receivung_time"));
        velMissionData.setFinishTime(msg.getString("finish_time"));
        velMissionData.setDeviceNum(msg.getString("device_num"));
        velMissionData.setContainerNo(msg.getString("container_no"));
        velMissionData.setId(msg.getIntValue("toss_id"));
        int count = WSListener.velMissionDataMapper.add(velMissionData);
        if (count > 0) {
            return Result.success();
        }
        return Result.error();
    }

    /**
     * 告警数据上传
     *
     * @param msg msg
     * @return Result
     */
    public Result warningDataAdd(JSONObject msg) {
        // 发送至Splunk系统
        new Thread(() -> splunkHttpApi.uploadWarnData(msg)).start();
        // 保存至本地数据库
        VelWarnData velWarnData = new VelWarnData();
        velWarnData.setDeviceNum(msg.getString("device_num"));
        velWarnData.setDeviceTime(msg.getString("device_time"));
        velWarnData.setWarningTurnlight(msg.getBooleanValue("warning_turnlight"));
        velWarnData.setWarningSpeaker(msg.getBooleanValue("warning_speaker"));
        velWarnData.setWarningTirepress(msg.getBooleanValue("warning_tirepress"));
        velWarnData.setWarningSeatbelt(msg.getBooleanValue("warning_seatbelt"));
        velWarnData.setWarningBacklight(msg.getBooleanValue("warning_backlight"));
        velWarnData.setWarningPress(msg.getBooleanValue("warning_press"));
        velWarnData.setWarningWiper(msg.getBooleanValue("warning_wiper"));
        velWarnData.setWarningFrontlight(msg.getBooleanValue("warning_frontlight"));
        velWarnData.setWarningLed(msg.getBooleanValue("warning_led"));
        velWarnData.setWarningAlarm(msg.getBooleanValue("warning_alarm"));
        velWarnData.setWarningBreak(msg.getBooleanValue("warning_break"));
        velWarnData.setWarningAcc(msg.getBooleanValue("warning_acc"));
        velWarnData.setWarningTurn(msg.getBooleanValue("warning_turn"));
        velWarnData.setLaserLag(msg.getBooleanValue("laser_lag"));
        velWarnData.setSingleLaser(msg.getBooleanValue("singlelaser"));
        velWarnData.setMultiLaser(msg.getBooleanValue("multilaser"));
        velWarnData.setCameraData(msg.getBooleanValue("cameradata"));
        velWarnData.setCameraLag(msg.getBooleanValue("camera_lag"));
        velWarnData.setMmradarLag(msg.getBooleanValue("mmradar_lag"));
        velWarnData.setMmraderBug(msg.getBooleanValue("mmrader_bug"));
        velWarnData.setWheelspeedLag(msg.getBooleanValue("wheelspeed_lag"));
        velWarnData.setWheelspeedSd(msg.getBooleanValue("wheelspeed_SD"));
        velWarnData.setAnglearsensorLag(msg.getBooleanValue("anglearsensor_lag"));
        velWarnData.setWarningHardbrake(msg.getBooleanValue("warning_hardbrake"));
        velWarnData.setWarningLwt(msg.getBooleanValue("warning_LWT"));
        velWarnData.setTurnMainstreet(msg.getBooleanValue("turn_mainstreet"));
        velWarnData.setTurnInbay(msg.getBooleanValue("turn_inbay"));
        velWarnData.setTurnDock(msg.getBooleanValue("turn_dock"));
        velWarnData.setTurnCharge(msg.getBooleanValue("turn_charge"));
        velWarnData.setTurnCurve(msg.getBooleanValue("turn_curve"));
        velWarnData.setGnssData(msg.getBooleanValue("GNSS_data"));
        velWarnData.setGnssLag(msg.getBooleanValue("GNSS_lag"));
        velWarnData.setImuData(msg.getBooleanValue("IMU_data"));
        velWarnData.setImuSd(msg.getBooleanValue("IMU_sd"));
        velWarnData.setLocationSd(msg.getBooleanValue("location_sd"));
        log.info("告警数据上传{}",velWarnData);
        int count = WSListener.velWarnDataMapper.add(velWarnData);
        emailService.createAlertInfo(velWarnData);
        if (count > 0) {
            return Result.success();
        }
        return Result.error();
    }

    /**
     * 任务数据上传
     *
     * @param msg msg
     * @return Result
     */
    public Result aligningDataAdd(JSONObject msg) {
        // 发送至Splunk系统
        new Thread(() -> splunkHttpApi.uploadAligningData(msg)).start();
        // 保存至本地数据库
        VelAligningData velAligningData = new VelAligningData();
        velAligningData.setContainerDev(msg.getString("container_dev"));
        velAligningData.setTimestamp(msg.getString("Timestamp"));
        velAligningData.setDeviceno(msg.getString("DeviceNo"));
        velAligningData.setTruckno(msg.getString("TruckNo"));
        velAligningData.setContainerNo(msg.getIntValue("container_no"));
        velAligningData.setRate(msg.getDoubleValue("Rate"));
        velAligningData.setControlMode(msg.getBooleanValue("Control_Mode"));
        int count = WSListener.velAligningDataMapper.add(velAligningData);
        if (count > 0) {
            return Result.success();
        }
        return Result.error();
    }

    /**
     * 障碍物数据上传
     *
     * @param msg msg
     * @return Result
     */
    public Result obstacleDataAdd(JSONObject msg) {
        // 发送至Splunk系统
        new Thread(() -> splunkHttpApi.uploadObstacleData(msg)).start();
        // 保存至本地数据库
        VelObstacleData velObstacleData = new VelObstacleData();
        velObstacleData.setDeviceNum(msg.getString("device_num"));
        velObstacleData.setObstacle1Status(msg.getString("obstacle1_status"));
        velObstacleData.setObstacle1Size(msg.getString("obstacle1_size"));
        velObstacleData.setObstacle1DistanceX(msg.getDoubleValue("obstacle1_distance_x"));
        velObstacleData.setObstacle1DistanceY(msg.getDoubleValue("obstacle1_distance_y"));
        velObstacleData.setObstacle1SpeedX(msg.getDoubleValue("obstacle1_speed_x"));
        velObstacleData.setObstacle1SpeedY(msg.getDoubleValue("obstacle1_speed_y"));
        velObstacleData.setObstacle1Collision(msg.getDoubleValue("obstacle1_collision"));
        velObstacleData.setObstacle1Safelevel(msg.getDoubleValue("obstacle1_safelevel"));
        velObstacleData.setObstacle2Status(msg.getString("obstacle2_status"));
        velObstacleData.setObstacle2Size(msg.getString("obstacle2_size"));
        velObstacleData.setObstacle2DistanceX(msg.getDoubleValue("obstacle2_distance_x"));
        velObstacleData.setObstacle2DistanceY(msg.getDoubleValue("obstacle2_distance_y"));
        velObstacleData.setObstacle2SpeedX(msg.getDoubleValue("obstacle2_speed_x"));
        velObstacleData.setObstacle2SpeedY(msg.getDoubleValue("obstacle2_speed_y"));
        velObstacleData.setObstacle2Collision(msg.getDoubleValue("obstacle2_collision"));
        velObstacleData.setObstacle2Safelevel(msg.getDoubleValue("obstacle2_safelevel"));
        velObstacleData.setObstacle3Status(msg.getString("obstacle3_status"));
        velObstacleData.setObstacle3Size(msg.getString("obstacle3_size"));
        velObstacleData.setObstacle3DistanceX(msg.getDoubleValue("obstacle3_distance_x"));
        velObstacleData.setObstacle3DistanceY(msg.getDoubleValue("obstacle3_distance_y"));
        velObstacleData.setObstacle3SpeedX(msg.getDoubleValue("obstacle3_speed_x"));
        velObstacleData.setObstacle3SpeedY(msg.getDoubleValue("obstacle3_speed_y"));
        velObstacleData.setObstacle3Collision(msg.getDoubleValue("obstacle3_collision"));
        velObstacleData.setObstacle3Safelevel(msg.getDoubleValue("obstacle3_safelevel"));
        velObstacleData.setArtIntervention(msg.getBooleanValue("art_intervention"));
        velObstacleData.setLineBreak(msg.getDoubleValue("line_break"));
        int count = WSListener.velObstacleDataMapper.add(velObstacleData);
        if (count > 0) {
            return Result.success();
        }
        return Result.error();
    }
}
