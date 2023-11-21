package com.deyi.daxie.cloud.service.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 
 * @TableName control_data
 */
@Data
@Getter
@Setter
@ToString
public class VelControlData implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 车号, TOS中车号
     */
    private String deviceNum;

    /**
     * 实际经度
     */
    private Double longitudeR;

    /**
     * 实际纬度
     */
    private Double latitudeR;

    /**
     * 规划经度
     */
    private Double longitudeD;

    /**
     * 规划纬度
     */
    private Double latitudeD;

    /**
     * 实际速度    单位km/h
     */
    private Double speedR;

    /**
     * 规划速度    单位km/h
     */
    private Integer speedD;

    /**
     * 区域限速    单位km/h
     */
    private Integer speedL;

    /**
     * 油门控制    取值范围0.0～1.0，代表期望油门的百分比。0.0对应0%不踩油门，1.0对应100%满油。油门期望/控制与反馈量和决策目标值差量之间统一度量衡
     */
    private Double throttleR;

    /**
     * 油门期望
     */
    private Double throttleD;

    /**
     * 底层油门反馈量与决策目标量差值
     */
    private Double throttleS;

    /**
     * 刹车控制    取值范围0.0～1.0，代表期望刹车的百分比。0.0对应0%不踩刹车，1.0对应100%踩死
     */
    private Double brakeR;

    /**
     * 刹车期望
     */
    private Double brakeD;

    /**
     * 底层制动反馈量与决策目标量差值
     */
    private Double brakeS;

    /**
     * 转向控制    取值范围-1.0~1.0，代表反馈方向盘转角的百分比。-1.0对应向左打满100%，0.0代表无转向，1.0代表向右打满100%
     */
    private Double wheelR;

    /**
     * 转向期望
     */
    private Double wheelD;

    /**
     * 底层转向反馈信息与决策目标量差值
     */
    private Double wheelS;

    /**
     * 挡位控制    取值范围：D、R、P、N，代表前进挡、倒车档、驻车档、空挡
     */
    private String gearR;

    /**
     * 挡位期望
     */
    private String gearD;

    /**
     * 车灯控制
     */
    private String lightR;

    /**
     * 车灯期望  取值范围：L、R、E、N，代表左转向、右转向、双闪、无
     */
    private String lightD;

    /**
     * 是否对位  对位中1，非对位0
     */
    private Integer isCp;

    /**
     * 是否对位开始  距目标点5米时触发；是：1，否：0
     */
    private Integer cpStart;

    /**
     * 是否对位结束  无人集卡确认对位完成；是：1，否：0
     */
    private Integer cpEnd;

    /**
     * 时间  yyyy-MM-dd HH:mm:ss
     */
    private String deviceTime;

    /**
     * 所在位置   1、集中装卸锁站 2、0W查验场地 3、熏蒸场地 4、CFS过磅场地 5、H986查验场地 6、调箱门场地 7、其它指定点位
     */
    private Integer position;

    /**
     * 车道中心线偏移
     */
    private Integer devDistance;

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
        VelControlData other = (VelControlData) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDeviceNum() == null ? other.getDeviceNum() == null : this.getDeviceNum().equals(other.getDeviceNum()))
            && (this.getLongitudeR() == null ? other.getLongitudeR() == null : this.getLongitudeR().equals(other.getLongitudeR()))
            && (this.getLatitudeR() == null ? other.getLatitudeR() == null : this.getLatitudeR().equals(other.getLatitudeR()))
            && (this.getLongitudeD() == null ? other.getLongitudeD() == null : this.getLongitudeD().equals(other.getLongitudeD()))
            && (this.getLatitudeD() == null ? other.getLatitudeD() == null : this.getLatitudeD().equals(other.getLatitudeD()))
            && (this.getSpeedR() == null ? other.getSpeedR() == null : this.getSpeedR().equals(other.getSpeedR()))
            && (this.getSpeedD() == null ? other.getSpeedD() == null : this.getSpeedD().equals(other.getSpeedD()))
            && (this.getSpeedL() == null ? other.getSpeedL() == null : this.getSpeedL().equals(other.getSpeedL()))
            && (this.getThrottleR() == null ? other.getThrottleR() == null : this.getThrottleR().equals(other.getThrottleR()))
            && (this.getThrottleD() == null ? other.getThrottleD() == null : this.getThrottleD().equals(other.getThrottleD()))
            && (this.getThrottleS() == null ? other.getThrottleS() == null : this.getThrottleS().equals(other.getThrottleS()))
            && (this.getBrakeR() == null ? other.getBrakeR() == null : this.getBrakeR().equals(other.getBrakeR()))
            && (this.getBrakeD() == null ? other.getBrakeD() == null : this.getBrakeD().equals(other.getBrakeD()))
            && (this.getBrakeS() == null ? other.getBrakeS() == null : this.getBrakeS().equals(other.getBrakeS()))
            && (this.getWheelR() == null ? other.getWheelR() == null : this.getWheelR().equals(other.getWheelR()))
            && (this.getWheelD() == null ? other.getWheelD() == null : this.getWheelD().equals(other.getWheelD()))
            && (this.getWheelS() == null ? other.getWheelS() == null : this.getWheelS().equals(other.getWheelS()))
            && (this.getGearR() == null ? other.getGearR() == null : this.getGearR().equals(other.getGearR()))
            && (this.getGearD() == null ? other.getGearD() == null : this.getGearD().equals(other.getGearD()))
            && (this.getLightR() == null ? other.getLightR() == null : this.getLightR().equals(other.getLightR()))
            && (this.getLightD() == null ? other.getLightD() == null : this.getLightD().equals(other.getLightD()))
            && (this.getIsCp() == null ? other.getIsCp() == null : this.getIsCp().equals(other.getIsCp()))
            && (this.getCpStart() == null ? other.getCpStart() == null : this.getCpStart().equals(other.getCpStart()))
            && (this.getCpEnd() == null ? other.getCpEnd() == null : this.getCpEnd().equals(other.getCpEnd()))
            && (this.getDeviceTime() == null ? other.getDeviceTime() == null : this.getDeviceTime().equals(other.getDeviceTime()))
            && (this.getPosition() == null ? other.getPosition() == null : this.getPosition().equals(other.getPosition()))
            && (this.getDevDistance() == null ? other.getDevDistance() == null : this.getDevDistance().equals(other.getDevDistance()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDeviceNum() == null) ? 0 : getDeviceNum().hashCode());
        result = prime * result + ((getLongitudeR() == null) ? 0 : getLongitudeR().hashCode());
        result = prime * result + ((getLatitudeR() == null) ? 0 : getLatitudeR().hashCode());
        result = prime * result + ((getLongitudeD() == null) ? 0 : getLongitudeD().hashCode());
        result = prime * result + ((getLatitudeD() == null) ? 0 : getLatitudeD().hashCode());
        result = prime * result + ((getSpeedR() == null) ? 0 : getSpeedR().hashCode());
        result = prime * result + ((getSpeedD() == null) ? 0 : getSpeedD().hashCode());
        result = prime * result + ((getSpeedL() == null) ? 0 : getSpeedL().hashCode());
        result = prime * result + ((getThrottleR() == null) ? 0 : getThrottleR().hashCode());
        result = prime * result + ((getThrottleD() == null) ? 0 : getThrottleD().hashCode());
        result = prime * result + ((getThrottleS() == null) ? 0 : getThrottleS().hashCode());
        result = prime * result + ((getBrakeR() == null) ? 0 : getBrakeR().hashCode());
        result = prime * result + ((getBrakeD() == null) ? 0 : getBrakeD().hashCode());
        result = prime * result + ((getBrakeS() == null) ? 0 : getBrakeS().hashCode());
        result = prime * result + ((getWheelR() == null) ? 0 : getWheelR().hashCode());
        result = prime * result + ((getWheelD() == null) ? 0 : getWheelD().hashCode());
        result = prime * result + ((getWheelS() == null) ? 0 : getWheelS().hashCode());
        result = prime * result + ((getGearR() == null) ? 0 : getGearR().hashCode());
        result = prime * result + ((getGearD() == null) ? 0 : getGearD().hashCode());
        result = prime * result + ((getLightR() == null) ? 0 : getLightR().hashCode());
        result = prime * result + ((getLightD() == null) ? 0 : getLightD().hashCode());
        result = prime * result + ((getIsCp() == null) ? 0 : getIsCp().hashCode());
        result = prime * result + ((getCpStart() == null) ? 0 : getCpStart().hashCode());
        result = prime * result + ((getCpEnd() == null) ? 0 : getCpEnd().hashCode());
        result = prime * result + ((getDeviceTime() == null) ? 0 : getDeviceTime().hashCode());
        result = prime * result + ((getPosition() == null) ? 0 : getPosition().hashCode());
        result = prime * result + ((getDevDistance() == null) ? 0 : getDevDistance().hashCode());
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
        sb.append(", longitudeR=").append(longitudeR);
        sb.append(", latitudeR=").append(latitudeR);
        sb.append(", longitudeD=").append(longitudeD);
        sb.append(", latitudeD=").append(latitudeD);
        sb.append(", speedR=").append(speedR);
        sb.append(", speedD=").append(speedD);
        sb.append(", speedL=").append(speedL);
        sb.append(", throttleR=").append(throttleR);
        sb.append(", throttleD=").append(throttleD);
        sb.append(", throttleS=").append(throttleS);
        sb.append(", brakeR=").append(brakeR);
        sb.append(", brakeD=").append(brakeD);
        sb.append(", brakeS=").append(brakeS);
        sb.append(", wheelR=").append(wheelR);
        sb.append(", wheelD=").append(wheelD);
        sb.append(", wheelS=").append(wheelS);
        sb.append(", gearR=").append(gearR);
        sb.append(", gearD=").append(gearD);
        sb.append(", lightR=").append(lightR);
        sb.append(", lightD=").append(lightD);
        sb.append(", isCp=").append(isCp);
        sb.append(", cpStart=").append(cpStart);
        sb.append(", cpEnd=").append(cpEnd);
        sb.append(", deviceTime=").append(deviceTime);
        sb.append(", position=").append(position);
        sb.append(", devDistance=").append(devDistance);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}