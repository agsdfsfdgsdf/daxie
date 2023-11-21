package com.deyi.daxie.cloud.service.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName tcs_upload_truck_status
 */
@Data
public class TcsUploadTruckStatus implements Serializable {
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
    private String paramTruckno;

    /**
     * 速度
     */
    private String paramSpeed;

    /**
     * 经度
     */
    private String paramLng;

    /**
     * 纬度
     */
    private String paramLat;

    /**
     * 时间
     */
    private String paramTime;

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
        TcsUploadTruckStatus other = (TcsUploadTruckStatus) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
            && (this.getTruckNo() == null ? other.getTruckNo() == null : this.getTruckNo().equals(other.getTruckNo()))
            && (this.getToken() == null ? other.getToken() == null : this.getToken().equals(other.getToken()))
            && (this.getParamTruckno() == null ? other.getParamTruckno() == null : this.getParamTruckno().equals(other.getParamTruckno()))
            && (this.getParamSpeed() == null ? other.getParamSpeed() == null : this.getParamSpeed().equals(other.getParamSpeed()))
            && (this.getParamLng() == null ? other.getParamLng() == null : this.getParamLng().equals(other.getParamLng()))
            && (this.getParamLat() == null ? other.getParamLat() == null : this.getParamLat().equals(other.getParamLat()))
            && (this.getParamTime() == null ? other.getParamTime() == null : this.getParamTime().equals(other.getParamTime()))
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
        result = prime * result + ((getParamTruckno() == null) ? 0 : getParamTruckno().hashCode());
        result = prime * result + ((getParamSpeed() == null) ? 0 : getParamSpeed().hashCode());
        result = prime * result + ((getParamLng() == null) ? 0 : getParamLng().hashCode());
        result = prime * result + ((getParamLat() == null) ? 0 : getParamLat().hashCode());
        result = prime * result + ((getParamTime() == null) ? 0 : getParamTime().hashCode());
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
        sb.append(", paramTruckno=").append(paramTruckno);
        sb.append(", paramSpeed=").append(paramSpeed);
        sb.append(", paramLng=").append(paramLng);
        sb.append(", paramLat=").append(paramLat);
        sb.append(", paramTime=").append(paramTime);
        sb.append(", resCode=").append(resCode);
        sb.append(", resMessage=").append(resMessage);
        sb.append(", resData=").append(resData);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}