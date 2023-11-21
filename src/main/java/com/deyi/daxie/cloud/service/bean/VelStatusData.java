package com.deyi.daxie.cloud.service.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @TableName vel_status_data
 */
@Data
public class VelStatusData implements Serializable {
    /**
     *
     */
    private Long id;

    /**
     * 车号，tos中车号
     */
    private String deviceNum;

    /**
     * 所属车队
     */
    private String fleet;

    /**
     * 能源模式，用油：O；用电：E；油电混合：M
     */
    private String energy;

    /**
     * 登录状态，登录：1；未登录：0；故障：9
     */
    private Integer loginStatus;

    /**
     * 作业模式，自动驾驶：0；人工驾驶：1；未登录：默认为-1
     */
    private Integer operationMode;

    /**
     * 版本号，当前发布的版本号
     */
    private String version;

    /**
     * 时间，yyyy-MM-dd HH:mm:ss
     */
    private String deviceTime;

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
        VelStatusData other = (VelStatusData) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getDeviceNum() == null ? other.getDeviceNum() == null : this.getDeviceNum().equals(other.getDeviceNum()))
                && (this.getFleet() == null ? other.getFleet() == null : this.getFleet().equals(other.getFleet()))
                && (this.getEnergy() == null ? other.getEnergy() == null : this.getEnergy().equals(other.getEnergy()))
                && (this.getLoginStatus() == null ? other.getLoginStatus() == null : this.getLoginStatus().equals(other.getLoginStatus()))
                && (this.getOperationMode() == null ? other.getOperationMode() == null : this.getOperationMode().equals(other.getOperationMode()))
                && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
                && (this.getDeviceTime() == null ? other.getDeviceTime() == null : this.getDeviceTime().equals(other.getDeviceTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDeviceNum() == null) ? 0 : getDeviceNum().hashCode());
        result = prime * result + ((getFleet() == null) ? 0 : getFleet().hashCode());
        result = prime * result + ((getEnergy() == null) ? 0 : getEnergy().hashCode());
        result = prime * result + ((getLoginStatus() == null) ? 0 : getLoginStatus().hashCode());
        result = prime * result + ((getOperationMode() == null) ? 0 : getOperationMode().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getDeviceTime() == null) ? 0 : getDeviceTime().hashCode());
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
        sb.append(", fleet=").append(fleet);
        sb.append(", energy=").append(energy);
        sb.append(", loginStatus=").append(loginStatus);
        sb.append(", operationMode=").append(operationMode);
        sb.append(", version=").append(version);
        sb.append(", deviceTime=").append(deviceTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}