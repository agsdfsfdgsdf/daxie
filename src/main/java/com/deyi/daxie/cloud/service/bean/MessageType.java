package com.deyi.daxie.cloud.service.bean;

import java.util.Objects;

public enum MessageType {
    LOGIN("Login", "登录请求"),
    LOGIN_OUT("Logout", "登出请求"),
    ALIVE("Alive", "心跳"),
    SET_TRUCK_STATUS("SetTruckStatus", "上传集卡状态请求"),
    GET_LED_MSG("GetLedMsg", "获取Led灯信息"),
    GET_LAST_ORDER("GetLastOrder", "查询最新的指令信息请求"),
    QC_INFO("QcInfo", "关路信息订阅请求"),
    QD_CPS_INFO("QdCpsInfo", "CPS信息订阅请求"),
    GET_YQ("GetYQ", "获取上下引桥信息请求"),
    LI_HUO("Lihuo", "理货上报车号功能请求"),
    TCS_QC_POSITION("TCSQcPosition", "桥吊下集卡到位"),
    GET_LANE("GetLane", "获取车道信息请求"),
    GET_GPS("GetGPS", "获取GPS信息请求"),
    SEND_PROMPT("SendPrompt", "发送提示信息请求"),
    CONFIRM_QC_CPS_END("ConfirmQCCpsEnd", "无人集卡桥吊下对位完成信息"),
    TCS_RTG_TRUCK("TCSRtgTruck", "无人集卡桥吊下对位完成信息"),
    GET_CHANGE_ROAD("GetChangeRoad", "无人集卡堆场内借道申请"),
    TCS_RTG_POSITION("TCSRtgPosition", "无人集卡堆场内到位上报"),
    RTG_INPLACE("RtgInplace", "龙门吊对位确认请求"),
    GET_LONG_MEN_DIAO_GPS("GetLongMenDiaoGps", "龙门吊对位确认请求"),
    GET_DUI_GAO_JI_GPS("GetDuiGaoJiGps", "获取堆高机GPS信息"),
    GET_QC_INFO("GetQcinfo", "获取桥吊移动信息"),
    YARD_MOVE("YardMove", "无人集卡接收作业完成可驶离信息"),
    RTG_MOVE_STATUS("RTGMoveStatus", "无人集卡订阅本栏内龙的行驶状态"),
    LOCK_ARRIVE("LockArrive", "装卸锁对接"),
    GET_ONLINE_STATUS("GetOnlineStatus", "查询TOS集卡在线状态"),
    GET_JK_GPS_ALL("GetJkGpsAll", "获取集卡GPS数据"),
    GET_TRUCK_UNLOCK("GetTruckUnlock", "查询集卡是否需要装卸锁"),

    SET_YQ("SetYQ", "上传引桥信息请求"),
    STATUS_DATA("StatusData", "车辆状态数据上报"),
    MISSION_DATA("MissionData", "车辆作业数据上报"),
    CONTROL_DATA("ControlData", "车辆控制数据上报"),
    WARN_DATA("WarnData", "车辆告警数据上报"),
    ALIGNING_DATA("AligningData", "车辆对位数据上报"),
    OBSTACLE_DATA("ObstacleData", "障碍物数据上报"),

    TOS_ORDER("TosOrder","指令信息获取"),

    QD_BAYS_CPSINFO("QdBaysCpsInfo","获取桥吊激光对位数据"),

    LMD_CPSINFO("LmdCpsInfo","龙门吊对位数据接收"),

    QC_MOVE_STATUS("QcMoveStatus","桥吊移动信息"),

    UN_LOCK("UnLock","装卸锁可驶离信息");

    /**
     * 接口类型
     */
    private final String type;
    /**
     * 接口描述
     */
    private final String alias;

    /**
     * 构造函数
     *
     * @param type  type
     * @param alias alias
     */
    private MessageType(String type, String alias) {
        this.type = type;
        this.alias = alias;
    }

    /**
     * 获取值
     *
     * @return String
     */
    public String getType() {
        return this.type;
    }

    /**
     * 获取接口描述
     *
     * @return String
     */
    public String getAlias() {
        return this.alias;
    }

    /**
     * 根据value返回枚举类型,主要在switch中使用
     *
     * @param value value
     * @return DataType
     */
    public static MessageType getByValue(String value) {
        for (MessageType dataType : values()) {
            if (Objects.equals(dataType.getType(), value)) {
                return dataType;
            }
        }
        return null;
    }
}
