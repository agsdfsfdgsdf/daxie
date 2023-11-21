package com.deyi.daxie.cloud.service.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName tcs_RTG_position
 */
@Data
public class TcsRtgPosition implements Serializable {
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
     * 设备编号
     */
    private String paramEpno;

    /**
     * True 到位  False 未到位
     */
    private String paramIsarrive;

    /**
     * 01-内集卡、02-外集卡、03-无人集卡、04-AIV、05-人工龙、06-远控龙、07-堆高机、08-正面吊、09-桥吊、10-其他
     */
    private String paramEptype;

    /**
     * 时间
     */
    private String paramArrivetime;

    /**
     * 栏贝位
     */
    private String paramPosition;

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
        TcsRtgPosition other = (TcsRtgPosition) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
            && (this.getTruckNo() == null ? other.getTruckNo() == null : this.getTruckNo().equals(other.getTruckNo()))
            && (this.getToken() == null ? other.getToken() == null : this.getToken().equals(other.getToken()))
            && (this.getParamEpno() == null ? other.getParamEpno() == null : this.getParamEpno().equals(other.getParamEpno()))
            && (this.getParamIsarrive() == null ? other.getParamIsarrive() == null : this.getParamIsarrive().equals(other.getParamIsarrive()))
            && (this.getParamEptype() == null ? other.getParamEptype() == null : this.getParamEptype().equals(other.getParamEptype()))
            && (this.getParamArrivetime() == null ? other.getParamArrivetime() == null : this.getParamArrivetime().equals(other.getParamArrivetime()))
            && (this.getParamPosition() == null ? other.getParamPosition() == null : this.getParamPosition().equals(other.getParamPosition()))
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
        result = prime * result + ((getParamEpno() == null) ? 0 : getParamEpno().hashCode());
        result = prime * result + ((getParamIsarrive() == null) ? 0 : getParamIsarrive().hashCode());
        result = prime * result + ((getParamEptype() == null) ? 0 : getParamEptype().hashCode());
        result = prime * result + ((getParamArrivetime() == null) ? 0 : getParamArrivetime().hashCode());
        result = prime * result + ((getParamPosition() == null) ? 0 : getParamPosition().hashCode());
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
        sb.append(", paramEpno=").append(paramEpno);
        sb.append(", paramIsarrive=").append(paramIsarrive);
        sb.append(", paramEptype=").append(paramEptype);
        sb.append(", paramArrivetime=").append(paramArrivetime);
        sb.append(", paramPosition=").append(paramPosition);
        sb.append(", resCode=").append(resCode);
        sb.append(", resMessage=").append(resMessage);
        sb.append(", resData=").append(resData);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}