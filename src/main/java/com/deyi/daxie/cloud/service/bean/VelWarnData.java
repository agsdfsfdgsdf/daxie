package com.deyi.daxie.cloud.service.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 
 * @TableName warn_data
 */
@Getter
@Setter
@ToString
@Data
public class VelWarnData implements Serializable {
    /**
     * 主键自增
     */
    private Long id;

    /**
     * 集卡号,TOS中车号 
     */
    private String deviceNum;

    /**
     * 时间,yyyy-MM-dd HH:mm:ss 
     */
    private String deviceTime;

    /**
     * 灯光（左转，右转，双闪）
     */
    private Boolean warningTurnlight;

    /**
     * 喇叭
     */
    private Boolean warningSpeaker;

    /**
     * 胎压
     */
    private Boolean warningTirepress;

    /**
     * 安全带
     */
    private Boolean warningSeatbelt;

    /**
     * 拖挂灯控
     */
    private Boolean warningBacklight;

    /**
     * 拖挂气路
     */
    private Boolean warningPress;

    /**
     * 雨刷
     */
    private Boolean warningWiper;

    /**
     * 大灯
     */
    private Boolean warningFrontlight;

    /**
     * LED屏
     */
    private Boolean warningLed;

    /**
     * 警示灯
     */
    private Boolean warningAlarm;

    /**
     * 无底层制动反馈信息
     */
    private Boolean warningBreak;

    /**
     * 无底层油门反馈信息
     */
    private Boolean warningAcc;

    /**
     * 无底层转角反馈信息
     */
    private Boolean warningTurn;

    /**
     * 激光雷达有无数据
     */
    private Boolean laserLag;

    /**
     * 激光雷达单帧点数异常
     */
    private Boolean singleLaser;

    /**
     * 激光雷达噪点异常
     */
    private Boolean multiLaser;

    /**
     * 摄像头无数据
     */
    private Boolean cameraData;

    /**
     * 摄像头数据异常-画面静止
     */
    private Boolean cameraLag;

    /**
     * 毫米波雷达无数据
     */
    private Boolean mmradarLag;

    /**
     * 毫米波雷达数据异常-障碍物信息异常
     */
    private Boolean mmraderBug;

    /**
     * 轮速计无数据
     */
    private Boolean wheelspeedLag;

    /**
     * 轮速计标准差过大
     */
    private Boolean wheelspeedSd;

    /**
     * 转角传感器无数据
     */
    private Boolean anglearsensorLag;

    /**
     * 急刹
     */
    private Boolean warningHardbrake;

    /**
     * 长时间等待
     */
    private Boolean warningLwt;

    /**
     * 转角阈值
     */
    private Boolean turnMainstreet;

    /**
     * 转角阈值
     */
    private Boolean turnInbay;

    /**
     * 转角阈值
     */
    private Boolean turnDock;

    /**
     * 转角阈值
     */
    private Boolean turnCharge;

    /**
     * 转角阈值
     */
    private Boolean turnCurve;

    /**
     * GNSS定位无数据
     */
    private Boolean gnssData;

    /**
     * GNSS定位信号弱
     */
    private Boolean gnssLag;

    /**
     * IMU无数据
     */
    private Boolean imuData;

    /**
     * IMU帧间方差过大
     */
    private Boolean imuSd;

    /**
     * 融合定位误差过大
     */
    private Boolean locationSd;

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        VelWarnData other = (VelWarnData) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDeviceNum() == null ? other.getDeviceNum() == null : this.getDeviceNum().equals(other.getDeviceNum()))
            && (this.getDeviceTime() == null ? other.getDeviceTime() == null : this.getDeviceTime().equals(other.getDeviceTime()))
            && (this.getWarningTurnlight() == null ? other.getWarningTurnlight() == null : this.getWarningTurnlight().equals(other.getWarningTurnlight()))
            && (this.getWarningSpeaker() == null ? other.getWarningSpeaker() == null : this.getWarningSpeaker().equals(other.getWarningSpeaker()))
            && (this.getWarningTirepress() == null ? other.getWarningTirepress() == null : this.getWarningTirepress().equals(other.getWarningTirepress()))
            && (this.getWarningSeatbelt() == null ? other.getWarningSeatbelt() == null : this.getWarningSeatbelt().equals(other.getWarningSeatbelt()))
            && (this.getWarningBacklight() == null ? other.getWarningBacklight() == null : this.getWarningBacklight().equals(other.getWarningBacklight()))
            && (this.getWarningPress() == null ? other.getWarningPress() == null : this.getWarningPress().equals(other.getWarningPress()))
            && (this.getWarningWiper() == null ? other.getWarningWiper() == null : this.getWarningWiper().equals(other.getWarningWiper()))
            && (this.getWarningFrontlight() == null ? other.getWarningFrontlight() == null : this.getWarningFrontlight().equals(other.getWarningFrontlight()))
            && (this.getWarningLed() == null ? other.getWarningLed() == null : this.getWarningLed().equals(other.getWarningLed()))
            && (this.getWarningAlarm() == null ? other.getWarningAlarm() == null : this.getWarningAlarm().equals(other.getWarningAlarm()))
            && (this.getWarningBreak() == null ? other.getWarningBreak() == null : this.getWarningBreak().equals(other.getWarningBreak()))
            && (this.getWarningAcc() == null ? other.getWarningAcc() == null : this.getWarningAcc().equals(other.getWarningAcc()))
            && (this.getWarningTurn() == null ? other.getWarningTurn() == null : this.getWarningTurn().equals(other.getWarningTurn()))
            && (this.getLaserLag() == null ? other.getLaserLag() == null : this.getLaserLag().equals(other.getLaserLag()))
            && (this.getSingleLaser() == null ? other.getSingleLaser() == null : this.getSingleLaser().equals(other.getSingleLaser()))
            && (this.getMultiLaser() == null ? other.getMultiLaser() == null : this.getMultiLaser().equals(other.getMultiLaser()))
            && (this.getCameraData() == null ? other.getCameraData() == null : this.getCameraData().equals(other.getCameraData()))
            && (this.getCameraLag() == null ? other.getCameraLag() == null : this.getCameraLag().equals(other.getCameraLag()))
            && (this.getMmradarLag() == null ? other.getMmradarLag() == null : this.getMmradarLag().equals(other.getMmradarLag()))
            && (this.getMmraderBug() == null ? other.getMmraderBug() == null : this.getMmraderBug().equals(other.getMmraderBug()))
            && (this.getWheelspeedLag() == null ? other.getWheelspeedLag() == null : this.getWheelspeedLag().equals(other.getWheelspeedLag()))
            && (this.getWheelspeedSd() == null ? other.getWheelspeedSd() == null : this.getWheelspeedSd().equals(other.getWheelspeedSd()))
            && (this.getAnglearsensorLag() == null ? other.getAnglearsensorLag() == null : this.getAnglearsensorLag().equals(other.getAnglearsensorLag()))
            && (this.getWarningHardbrake() == null ? other.getWarningHardbrake() == null : this.getWarningHardbrake().equals(other.getWarningHardbrake()))
            && (this.getWarningLwt() == null ? other.getWarningLwt() == null : this.getWarningLwt().equals(other.getWarningLwt()))
            && (this.getTurnMainstreet() == null ? other.getTurnMainstreet() == null : this.getTurnMainstreet().equals(other.getTurnMainstreet()))
            && (this.getTurnInbay() == null ? other.getTurnInbay() == null : this.getTurnInbay().equals(other.getTurnInbay()))
            && (this.getTurnDock() == null ? other.getTurnDock() == null : this.getTurnDock().equals(other.getTurnDock()))
            && (this.getTurnCharge() == null ? other.getTurnCharge() == null : this.getTurnCharge().equals(other.getTurnCharge()))
            && (this.getTurnCurve() == null ? other.getTurnCurve() == null : this.getTurnCurve().equals(other.getTurnCurve()))
            && (this.getGnssData() == null ? other.getGnssData() == null : this.getGnssData().equals(other.getGnssData()))
            && (this.getGnssLag() == null ? other.getGnssLag() == null : this.getGnssLag().equals(other.getGnssLag()))
            && (this.getImuData() == null ? other.getImuData() == null : this.getImuData().equals(other.getImuData()))
            && (this.getImuSd() == null ? other.getImuSd() == null : this.getImuSd().equals(other.getImuSd()))
            && (this.getLocationSd() == null ? other.getLocationSd() == null : this.getLocationSd().equals(other.getLocationSd()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDeviceNum() == null) ? 0 : getDeviceNum().hashCode());
        result = prime * result + ((getDeviceTime() == null) ? 0 : getDeviceTime().hashCode());
        result = prime * result + ((getWarningTurnlight() == null) ? 0 : getWarningTurnlight().hashCode());
        result = prime * result + ((getWarningSpeaker() == null) ? 0 : getWarningSpeaker().hashCode());
        result = prime * result + ((getWarningTirepress() == null) ? 0 : getWarningTirepress().hashCode());
        result = prime * result + ((getWarningSeatbelt() == null) ? 0 : getWarningSeatbelt().hashCode());
        result = prime * result + ((getWarningBacklight() == null) ? 0 : getWarningBacklight().hashCode());
        result = prime * result + ((getWarningPress() == null) ? 0 : getWarningPress().hashCode());
        result = prime * result + ((getWarningWiper() == null) ? 0 : getWarningWiper().hashCode());
        result = prime * result + ((getWarningFrontlight() == null) ? 0 : getWarningFrontlight().hashCode());
        result = prime * result + ((getWarningLed() == null) ? 0 : getWarningLed().hashCode());
        result = prime * result + ((getWarningAlarm() == null) ? 0 : getWarningAlarm().hashCode());
        result = prime * result + ((getWarningBreak() == null) ? 0 : getWarningBreak().hashCode());
        result = prime * result + ((getWarningAcc() == null) ? 0 : getWarningAcc().hashCode());
        result = prime * result + ((getWarningTurn() == null) ? 0 : getWarningTurn().hashCode());
        result = prime * result + ((getLaserLag() == null) ? 0 : getLaserLag().hashCode());
        result = prime * result + ((getSingleLaser() == null) ? 0 : getSingleLaser().hashCode());
        result = prime * result + ((getMultiLaser() == null) ? 0 : getMultiLaser().hashCode());
        result = prime * result + ((getCameraData() == null) ? 0 : getCameraData().hashCode());
        result = prime * result + ((getCameraLag() == null) ? 0 : getCameraLag().hashCode());
        result = prime * result + ((getMmradarLag() == null) ? 0 : getMmradarLag().hashCode());
        result = prime * result + ((getMmraderBug() == null) ? 0 : getMmraderBug().hashCode());
        result = prime * result + ((getWheelspeedLag() == null) ? 0 : getWheelspeedLag().hashCode());
        result = prime * result + ((getWheelspeedSd() == null) ? 0 : getWheelspeedSd().hashCode());
        result = prime * result + ((getAnglearsensorLag() == null) ? 0 : getAnglearsensorLag().hashCode());
        result = prime * result + ((getWarningHardbrake() == null) ? 0 : getWarningHardbrake().hashCode());
        result = prime * result + ((getWarningLwt() == null) ? 0 : getWarningLwt().hashCode());
        result = prime * result + ((getTurnMainstreet() == null) ? 0 : getTurnMainstreet().hashCode());
        result = prime * result + ((getTurnInbay() == null) ? 0 : getTurnInbay().hashCode());
        result = prime * result + ((getTurnDock() == null) ? 0 : getTurnDock().hashCode());
        result = prime * result + ((getTurnCharge() == null) ? 0 : getTurnCharge().hashCode());
        result = prime * result + ((getTurnCurve() == null) ? 0 : getTurnCurve().hashCode());
        result = prime * result + ((getGnssData() == null) ? 0 : getGnssData().hashCode());
        result = prime * result + ((getGnssLag() == null) ? 0 : getGnssLag().hashCode());
        result = prime * result + ((getImuData() == null) ? 0 : getImuData().hashCode());
        result = prime * result + ((getImuSd() == null) ? 0 : getImuSd().hashCode());
        result = prime * result + ((getLocationSd() == null) ? 0 : getLocationSd().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", deviceNum=").append(deviceNum);
        sb.append(", deviceTime=").append(deviceTime);
        sb.append(", warningTurnlight=").append(warningTurnlight);
        sb.append(", warningSpeaker=").append(warningSpeaker);
        sb.append(", warningTirepress=").append(warningTirepress);
        sb.append(", warningSeatbelt=").append(warningSeatbelt);
        sb.append(", warningBacklight=").append(warningBacklight);
        sb.append(", warningPress=").append(warningPress);
        sb.append(", warningWiper=").append(warningWiper);
        sb.append(", warningFrontlight=").append(warningFrontlight);
        sb.append(", warningLed=").append(warningLed);
        sb.append(", warningAlarm=").append(warningAlarm);
        sb.append(", warningBreak=").append(warningBreak);
        sb.append(", warningAcc=").append(warningAcc);
        sb.append(", warningTurn=").append(warningTurn);
        sb.append(", laserLag=").append(laserLag);
        sb.append(", singleLaser=").append(singleLaser);
        sb.append(", multiLaser=").append(multiLaser);
        sb.append(", cameraData=").append(cameraData);
        sb.append(", cameraLag=").append(cameraLag);
        sb.append(", mmradarLag=").append(mmradarLag);
        sb.append(", mmraderBug=").append(mmraderBug);
        sb.append(", wheelspeedLag=").append(wheelspeedLag);
        sb.append(", wheelspeedSd=").append(wheelspeedSd);
        sb.append(", anglearsensorLag=").append(anglearsensorLag);
        sb.append(", warningHardbrake=").append(warningHardbrake);
        sb.append(", warningLwt=").append(warningLwt);
        sb.append(", turnMainstreet=").append(turnMainstreet);
        sb.append(", turnInbay=").append(turnInbay);
        sb.append(", turnDock=").append(turnDock);
        sb.append(", turnCharge=").append(turnCharge);
        sb.append(", turnCurve=").append(turnCurve);
        sb.append(", gnssData=").append(gnssData);
        sb.append(", gnssLag=").append(gnssLag);
        sb.append(", imuData=").append(imuData);
        sb.append(", imuSd=").append(imuSd);
        sb.append(", locationSd=").append(locationSd);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}