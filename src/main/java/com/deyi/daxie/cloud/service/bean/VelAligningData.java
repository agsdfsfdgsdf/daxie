package com.deyi.daxie.cloud.service.bean;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @TableName aligning_data
 */
@Getter
@Setter
@ToString
@Data
public class VelAligningData implements Serializable {
    /**
     * 主键自增
     */
    private Long id;

    /**
     * 对位设备类型,激光对位，视觉对位，龙门吊对位 
     */
    private String containerDev;

    /**
     * 时间戳,yyyy-MM-dd HH:mm:ss 
     */
    private String timestamp;

    /**
     * 设备号
     */
    private String deviceno;

    /**
     * 集卡号, 
     */
    private String truckno;

    /**
     * 具体移动的物理值, 
     */
    private Integer containerNo;

    /**
     * 具体移动的百分比,匹配Toss任务ID 
     */
    private Double rate;

    /**
     * 操作模式,True自动对位 False 人工对位 
     */
    private Boolean controlMode;

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
        VelAligningData other = (VelAligningData) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getContainerDev() == null ? other.getContainerDev() == null : this.getContainerDev().equals(other.getContainerDev()))
            && (this.getTimestamp() == null ? other.getTimestamp() == null : this.getTimestamp().equals(other.getTimestamp()))
            && (this.getDeviceno() == null ? other.getDeviceno() == null : this.getDeviceno().equals(other.getDeviceno()))
            && (this.getTruckno() == null ? other.getTruckno() == null : this.getTruckno().equals(other.getTruckno()))
            && (this.getContainerNo() == null ? other.getContainerNo() == null : this.getContainerNo().equals(other.getContainerNo()))
            && (this.getRate() == null ? other.getRate() == null : this.getRate().equals(other.getRate()))
            && (this.getControlMode() == null ? other.getControlMode() == null : this.getControlMode().equals(other.getControlMode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getContainerDev() == null) ? 0 : getContainerDev().hashCode());
        result = prime * result + ((getTimestamp() == null) ? 0 : getTimestamp().hashCode());
        result = prime * result + ((getDeviceno() == null) ? 0 : getDeviceno().hashCode());
        result = prime * result + ((getTruckno() == null) ? 0 : getTruckno().hashCode());
        result = prime * result + ((getContainerNo() == null) ? 0 : getContainerNo().hashCode());
        result = prime * result + ((getRate() == null) ? 0 : getRate().hashCode());
        result = prime * result + ((getControlMode() == null) ? 0 : getControlMode().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", containerDev=").append(containerDev);
        sb.append(", timestamp=").append(timestamp);
        sb.append(", deviceno=").append(deviceno);
        sb.append(", truckno=").append(truckno);
        sb.append(", containerNo=").append(containerNo);
        sb.append(", rate=").append(rate);
        sb.append(", controlMode=").append(controlMode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}