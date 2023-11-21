package com.deyi.daxie.cloud.service.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName tcs_RTG_change_road
 */
@Data
public class TcsRtgChangeRoad implements Serializable {
    /**
     * 主键，自增
     */
    private Long id;

    /**
     * 请求时间
     */
    private Date time;

    /**
     * 发出请求的集卡号
     */
    private String truckNo;

    /**
     * 请求token
     */
    private String token;

    /**
     * 集卡号
     */
    private String paramTruck;

    /**
     * 栏贝位
     */
    private String paramTarget;

    /**
     * 时间
     */
    private String paramTime;

    /**
     * 0-作业车道，1-借车道
     */
    private String paramLane;

    /**
     * 返回状态码
     */
    private String resCode;

    /**
     * msg
     */
    private String resMessage;

    /**
     * 返回数据
     */
    private String resData;

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
        TcsRtgChangeRoad other = (TcsRtgChangeRoad) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
            && (this.getTruckNo() == null ? other.getTruckNo() == null : this.getTruckNo().equals(other.getTruckNo()))
            && (this.getToken() == null ? other.getToken() == null : this.getToken().equals(other.getToken()))
            && (this.getParamTruck() == null ? other.getParamTruck() == null : this.getParamTruck().equals(other.getParamTruck()))
            && (this.getParamTarget() == null ? other.getParamTarget() == null : this.getParamTarget().equals(other.getParamTarget()))
            && (this.getParamTime() == null ? other.getParamTime() == null : this.getParamTime().equals(other.getParamTime()))
            && (this.getParamLane() == null ? other.getParamLane() == null : this.getParamLane().equals(other.getParamLane()))
            && (this.getResCode() == null ? other.getResCode() == null : this.getResCode().equals(other.getResCode()))
            && (this.getResMessage() == null ? other.getResMessage() == null : this.getResMessage().equals(other.getResMessage()))
            && (this.getResData() == null ? other.getResData() == null : this.getResData().equals(other.getResData()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        result = prime * result + ((getTruckNo() == null) ? 0 : getTruckNo().hashCode());
        result = prime * result + ((getToken() == null) ? 0 : getToken().hashCode());
        result = prime * result + ((getParamTruck() == null) ? 0 : getParamTruck().hashCode());
        result = prime * result + ((getParamTarget() == null) ? 0 : getParamTarget().hashCode());
        result = prime * result + ((getParamTime() == null) ? 0 : getParamTime().hashCode());
        result = prime * result + ((getParamLane() == null) ? 0 : getParamLane().hashCode());
        result = prime * result + ((getResCode() == null) ? 0 : getResCode().hashCode());
        result = prime * result + ((getResMessage() == null) ? 0 : getResMessage().hashCode());
        result = prime * result + ((getResData() == null) ? 0 : getResData().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", time=").append(time);
        sb.append(", truckNo=").append(truckNo);
        sb.append(", token=").append(token);
        sb.append(", paramTruck=").append(paramTruck);
        sb.append(", paramTarget=").append(paramTarget);
        sb.append(", paramTime=").append(paramTime);
        sb.append(", paramLane=").append(paramLane);
        sb.append(", resCode=").append(resCode);
        sb.append(", resMessage=").append(resMessage);
        sb.append(", resData=").append(resData);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}