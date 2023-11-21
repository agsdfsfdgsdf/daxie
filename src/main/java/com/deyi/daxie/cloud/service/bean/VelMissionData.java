package com.deyi.daxie.cloud.service.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @TableName vel_mission_data
 */
@Data
public class VelMissionData implements Serializable {
    /**
     * 主键自增
     */
    private Long tableId;

    /**
     * 落箱距离误差值  集卡背箱时与标准位置的误差判断
     */
    private Double containerDev;

    /**
     * 接受指令时间  yyyy-MM-dd HH:mm:ss
     */
    private String receivungTime;

    /**
     * 指令完成时间  yyyy-MM-dd HH:mm:ss
     */
    private String finishTime;

    /**
     * 集卡号
     */
    private String deviceNum;

    /**
     * 作业箱号
     */
    private String containerNo;

    /**
     * 匹配Toss任务ID
     */
    private Integer id;

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
        VelMissionData other = (VelMissionData) that;
        return (this.getTableId() == null ? other.getTableId() == null : this.getTableId().equals(other.getTableId()))
                && (this.getContainerDev() == null ? other.getContainerDev() == null : this.getContainerDev().equals(other.getContainerDev()))
                && (this.getReceivungTime() == null ? other.getReceivungTime() == null : this.getReceivungTime().equals(other.getReceivungTime()))
                && (this.getFinishTime() == null ? other.getFinishTime() == null : this.getFinishTime().equals(other.getFinishTime()))
                && (this.getDeviceNum() == null ? other.getDeviceNum() == null : this.getDeviceNum().equals(other.getDeviceNum()))
                && (this.getContainerNo() == null ? other.getContainerNo() == null : this.getContainerNo().equals(other.getContainerNo()))
                && (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTableId() == null) ? 0 : getTableId().hashCode());
        result = prime * result + ((getContainerDev() == null) ? 0 : getContainerDev().hashCode());
        result = prime * result + ((getReceivungTime() == null) ? 0 : getReceivungTime().hashCode());
        result = prime * result + ((getFinishTime() == null) ? 0 : getFinishTime().hashCode());
        result = prime * result + ((getDeviceNum() == null) ? 0 : getDeviceNum().hashCode());
        result = prime * result + ((getContainerNo() == null) ? 0 : getContainerNo().hashCode());
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tableId=").append(tableId);
        sb.append(", containerDev=").append(containerDev);
        sb.append(", receivungTime=").append(receivungTime);
        sb.append(", finishTime=").append(finishTime);
        sb.append(", deviceNum=").append(deviceNum);
        sb.append(", containerNo=").append(containerNo);
        sb.append(", id=").append(id);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}