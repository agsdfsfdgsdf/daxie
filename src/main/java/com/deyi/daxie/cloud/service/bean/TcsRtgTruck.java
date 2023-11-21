package com.deyi.daxie.cloud.service.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName tcs_RTG_truck
 */
@Data
public class TcsRtgTruck implements Serializable {
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
     * 栏位
     */
    private String paramColumn;

    /**
     * 时间
     */
    private String paramTime;

    /**
     * 0  进栏 1 出栏
     */
    private String paramType;

    /**
     * 0-直行，1-左转，2-右转，如是出栏不允许为空
     */
    private String paramDirection;

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
        TcsRtgTruck other = (TcsRtgTruck) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
            && (this.getTruckNo() == null ? other.getTruckNo() == null : this.getTruckNo().equals(other.getTruckNo()))
            && (this.getToken() == null ? other.getToken() == null : this.getToken().equals(other.getToken()))
            && (this.getParamTruck() == null ? other.getParamTruck() == null : this.getParamTruck().equals(other.getParamTruck()))
            && (this.getParamColumn() == null ? other.getParamColumn() == null : this.getParamColumn().equals(other.getParamColumn()))
            && (this.getParamTime() == null ? other.getParamTime() == null : this.getParamTime().equals(other.getParamTime()))
            && (this.getParamType() == null ? other.getParamType() == null : this.getParamType().equals(other.getParamType()))
            && (this.getParamDirection() == null ? other.getParamDirection() == null : this.getParamDirection().equals(other.getParamDirection()))
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
        result = prime * result + ((getParamColumn() == null) ? 0 : getParamColumn().hashCode());
        result = prime * result + ((getParamTime() == null) ? 0 : getParamTime().hashCode());
        result = prime * result + ((getParamType() == null) ? 0 : getParamType().hashCode());
        result = prime * result + ((getParamDirection() == null) ? 0 : getParamDirection().hashCode());
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
        sb.append(", paramColumn=").append(paramColumn);
        sb.append(", paramTime=").append(paramTime);
        sb.append(", paramType=").append(paramType);
        sb.append(", paramDirection=").append(paramDirection);
        sb.append(", resCode=").append(resCode);
        sb.append(", resMessage=").append(resMessage);
        sb.append(", resData=").append(resData);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}