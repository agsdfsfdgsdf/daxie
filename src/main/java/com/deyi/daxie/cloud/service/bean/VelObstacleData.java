package com.deyi.daxie.cloud.service.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName vel_obstacle_data
 */
@Data
public class VelObstacleData implements Serializable {
    /**
     * 主键自增
     */
    private Long id;

    /**
     * 集卡号,TOS中车号 
     */
    private String deviceNum;

    /**
     * 障碍物类型,龙门吊:R；桥吊：Q；集卡：T；小车：C；其他静态障碍物：E；其他动态障碍物：M---厂商
     */
    private String obstacle1Status;

    /**
     * 长*宽*高
     */
    private String obstacle1Size;

    /**
     * 感知障碍物1 X位置
     */
    private Double obstacle1DistanceX;

    /**
     * 感知障碍物1 Y位置
     */
    private Double obstacle1DistanceY;

    /**
     * 感知障碍物1 X速度
     */
    private Double obstacle1SpeedX;

    /**
     * 感知障碍物1 Y速度
     */
    private Double obstacle1SpeedY;

    /**
     * 感知障碍物1碰撞时间
     */
    private Double obstacle1Collision;

    /**
     * 感知障碍物1置信度
     */
    private Double obstacle1Safelevel;

    /**
     * 障碍物类型,龙门吊:R；桥吊：Q；集卡：T；小车：C；其他静态障碍物：E；其他动态障碍物：M---厂商
     */
    private String obstacle2Status;

    /**
     * 长*宽*高
     */
    private String obstacle2Size;

    /**
     * 感知障碍物2 X位置
     */
    private Double obstacle2DistanceX;

    /**
     * 感知障碍物2 Y位置
     */
    private Double obstacle2DistanceY;

    /**
     * 感知障碍物2 X速度
     */
    private Double obstacle2SpeedX;

    /**
     * 感知障碍物2 Y速度
     */
    private Double obstacle2SpeedY;

    /**
     * 感知障碍物2碰撞时间
     */
    private Double obstacle2Collision;

    /**
     * 感知障碍物2置信度
     */
    private Double obstacle2Safelevel;

    /**
     * 障碍物类型,龙门吊:R；桥吊：Q；集卡：T；小车：C；其他静态障碍物：E；其他动态障碍物：M---厂商
     */
    private String obstacle3Status;

    /**
     * 长*宽*高
     */
    private String obstacle3Size;

    /**
     * 感知障碍物3 X位置
     */
    private Double obstacle3DistanceX;

    /**
     * 感知障碍物3 Y位置
     */
    private Double obstacle3DistanceY;

    /**
     * 感知障碍物3 X速度
     */
    private Double obstacle3SpeedX;

    /**
     * 感知障碍物3 Y速度
     */
    private Double obstacle3SpeedY;

    /**
     * 感知障碍物3碰撞时间
     */
    private Double obstacle3Collision;

    /**
     * 感知障碍物3置信度
     */
    private Double obstacle3Safelevel;

    /**
     * 人工介入
     */
    private Boolean artIntervention;

    /**
     * 因车道线质量差无法准确识别,因车道线质量差无法准确识别0.00-1，数字越大表示质量越好
     */
    private Double lineBreak;

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
        VelObstacleData other = (VelObstacleData) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDeviceNum() == null ? other.getDeviceNum() == null : this.getDeviceNum().equals(other.getDeviceNum()))
            && (this.getObstacle1Status() == null ? other.getObstacle1Status() == null : this.getObstacle1Status().equals(other.getObstacle1Status()))
            && (this.getObstacle1Size() == null ? other.getObstacle1Size() == null : this.getObstacle1Size().equals(other.getObstacle1Size()))
            && (this.getObstacle1DistanceX() == null ? other.getObstacle1DistanceX() == null : this.getObstacle1DistanceX().equals(other.getObstacle1DistanceX()))
            && (this.getObstacle1DistanceY() == null ? other.getObstacle1DistanceY() == null : this.getObstacle1DistanceY().equals(other.getObstacle1DistanceY()))
            && (this.getObstacle1SpeedX() == null ? other.getObstacle1SpeedX() == null : this.getObstacle1SpeedX().equals(other.getObstacle1SpeedX()))
            && (this.getObstacle1SpeedY() == null ? other.getObstacle1SpeedY() == null : this.getObstacle1SpeedY().equals(other.getObstacle1SpeedY()))
            && (this.getObstacle1Collision() == null ? other.getObstacle1Collision() == null : this.getObstacle1Collision().equals(other.getObstacle1Collision()))
            && (this.getObstacle1Safelevel() == null ? other.getObstacle1Safelevel() == null : this.getObstacle1Safelevel().equals(other.getObstacle1Safelevel()))
            && (this.getObstacle2Status() == null ? other.getObstacle2Status() == null : this.getObstacle2Status().equals(other.getObstacle2Status()))
            && (this.getObstacle2Size() == null ? other.getObstacle2Size() == null : this.getObstacle2Size().equals(other.getObstacle2Size()))
            && (this.getObstacle2DistanceX() == null ? other.getObstacle2DistanceX() == null : this.getObstacle2DistanceX().equals(other.getObstacle2DistanceX()))
            && (this.getObstacle2DistanceY() == null ? other.getObstacle2DistanceY() == null : this.getObstacle2DistanceY().equals(other.getObstacle2DistanceY()))
            && (this.getObstacle2SpeedX() == null ? other.getObstacle2SpeedX() == null : this.getObstacle2SpeedX().equals(other.getObstacle2SpeedX()))
            && (this.getObstacle2SpeedY() == null ? other.getObstacle2SpeedY() == null : this.getObstacle2SpeedY().equals(other.getObstacle2SpeedY()))
            && (this.getObstacle2Collision() == null ? other.getObstacle2Collision() == null : this.getObstacle2Collision().equals(other.getObstacle2Collision()))
            && (this.getObstacle2Safelevel() == null ? other.getObstacle2Safelevel() == null : this.getObstacle2Safelevel().equals(other.getObstacle2Safelevel()))
            && (this.getObstacle3Status() == null ? other.getObstacle3Status() == null : this.getObstacle3Status().equals(other.getObstacle3Status()))
            && (this.getObstacle3Size() == null ? other.getObstacle3Size() == null : this.getObstacle3Size().equals(other.getObstacle3Size()))
            && (this.getObstacle3DistanceX() == null ? other.getObstacle3DistanceX() == null : this.getObstacle3DistanceX().equals(other.getObstacle3DistanceX()))
            && (this.getObstacle3DistanceY() == null ? other.getObstacle3DistanceY() == null : this.getObstacle3DistanceY().equals(other.getObstacle3DistanceY()))
            && (this.getObstacle3SpeedX() == null ? other.getObstacle3SpeedX() == null : this.getObstacle3SpeedX().equals(other.getObstacle3SpeedX()))
            && (this.getObstacle3SpeedY() == null ? other.getObstacle3SpeedY() == null : this.getObstacle3SpeedY().equals(other.getObstacle3SpeedY()))
            && (this.getObstacle3Collision() == null ? other.getObstacle3Collision() == null : this.getObstacle3Collision().equals(other.getObstacle3Collision()))
            && (this.getObstacle3Safelevel() == null ? other.getObstacle3Safelevel() == null : this.getObstacle3Safelevel().equals(other.getObstacle3Safelevel()))
            && (this.getArtIntervention() == null ? other.getArtIntervention() == null : this.getArtIntervention().equals(other.getArtIntervention()))
            && (this.getLineBreak() == null ? other.getLineBreak() == null : this.getLineBreak().equals(other.getLineBreak()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDeviceNum() == null) ? 0 : getDeviceNum().hashCode());
        result = prime * result + ((getObstacle1Status() == null) ? 0 : getObstacle1Status().hashCode());
        result = prime * result + ((getObstacle1Size() == null) ? 0 : getObstacle1Size().hashCode());
        result = prime * result + ((getObstacle1DistanceX() == null) ? 0 : getObstacle1DistanceX().hashCode());
        result = prime * result + ((getObstacle1DistanceY() == null) ? 0 : getObstacle1DistanceY().hashCode());
        result = prime * result + ((getObstacle1SpeedX() == null) ? 0 : getObstacle1SpeedX().hashCode());
        result = prime * result + ((getObstacle1SpeedY() == null) ? 0 : getObstacle1SpeedY().hashCode());
        result = prime * result + ((getObstacle1Collision() == null) ? 0 : getObstacle1Collision().hashCode());
        result = prime * result + ((getObstacle1Safelevel() == null) ? 0 : getObstacle1Safelevel().hashCode());
        result = prime * result + ((getObstacle2Status() == null) ? 0 : getObstacle2Status().hashCode());
        result = prime * result + ((getObstacle2Size() == null) ? 0 : getObstacle2Size().hashCode());
        result = prime * result + ((getObstacle2DistanceX() == null) ? 0 : getObstacle2DistanceX().hashCode());
        result = prime * result + ((getObstacle2DistanceY() == null) ? 0 : getObstacle2DistanceY().hashCode());
        result = prime * result + ((getObstacle2SpeedX() == null) ? 0 : getObstacle2SpeedX().hashCode());
        result = prime * result + ((getObstacle2SpeedY() == null) ? 0 : getObstacle2SpeedY().hashCode());
        result = prime * result + ((getObstacle2Collision() == null) ? 0 : getObstacle2Collision().hashCode());
        result = prime * result + ((getObstacle2Safelevel() == null) ? 0 : getObstacle2Safelevel().hashCode());
        result = prime * result + ((getObstacle3Status() == null) ? 0 : getObstacle3Status().hashCode());
        result = prime * result + ((getObstacle3Size() == null) ? 0 : getObstacle3Size().hashCode());
        result = prime * result + ((getObstacle3DistanceX() == null) ? 0 : getObstacle3DistanceX().hashCode());
        result = prime * result + ((getObstacle3DistanceY() == null) ? 0 : getObstacle3DistanceY().hashCode());
        result = prime * result + ((getObstacle3SpeedX() == null) ? 0 : getObstacle3SpeedX().hashCode());
        result = prime * result + ((getObstacle3SpeedY() == null) ? 0 : getObstacle3SpeedY().hashCode());
        result = prime * result + ((getObstacle3Collision() == null) ? 0 : getObstacle3Collision().hashCode());
        result = prime * result + ((getObstacle3Safelevel() == null) ? 0 : getObstacle3Safelevel().hashCode());
        result = prime * result + ((getArtIntervention() == null) ? 0 : getArtIntervention().hashCode());
        result = prime * result + ((getLineBreak() == null) ? 0 : getLineBreak().hashCode());
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
        sb.append(", obstacle1Status=").append(obstacle1Status);
        sb.append(", obstacle1Size=").append(obstacle1Size);
        sb.append(", obstacle1DistanceX=").append(obstacle1DistanceX);
        sb.append(", obstacle1DistanceY=").append(obstacle1DistanceY);
        sb.append(", obstacle1SpeedX=").append(obstacle1SpeedX);
        sb.append(", obstacle1SpeedY=").append(obstacle1SpeedY);
        sb.append(", obstacle1Collision=").append(obstacle1Collision);
        sb.append(", obstacle1Safelevel=").append(obstacle1Safelevel);
        sb.append(", obstacle2Status=").append(obstacle2Status);
        sb.append(", obstacle2Size=").append(obstacle2Size);
        sb.append(", obstacle2DistanceX=").append(obstacle2DistanceX);
        sb.append(", obstacle2DistanceY=").append(obstacle2DistanceY);
        sb.append(", obstacle2SpeedX=").append(obstacle2SpeedX);
        sb.append(", obstacle2SpeedY=").append(obstacle2SpeedY);
        sb.append(", obstacle2Collision=").append(obstacle2Collision);
        sb.append(", obstacle2Safelevel=").append(obstacle2Safelevel);
        sb.append(", obstacle3Status=").append(obstacle3Status);
        sb.append(", obstacle3Size=").append(obstacle3Size);
        sb.append(", obstacle3DistanceX=").append(obstacle3DistanceX);
        sb.append(", obstacle3DistanceY=").append(obstacle3DistanceY);
        sb.append(", obstacle3SpeedX=").append(obstacle3SpeedX);
        sb.append(", obstacle3SpeedY=").append(obstacle3SpeedY);
        sb.append(", obstacle3Collision=").append(obstacle3Collision);
        sb.append(", obstacle3Safelevel=").append(obstacle3Safelevel);
        sb.append(", artIntervention=").append(artIntervention);
        sb.append(", lineBreak=").append(lineBreak);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}