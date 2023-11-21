package com.deyi.daxie.cloud.service.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName tcs_websocket_get_qd_gps
 */
@Data
public class TcsWebsocketGetQdGps implements Serializable {
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
     * 
     */
    private String resReceiver;

    /**
     * 
     */
    private String resMessagetype;

    /**
     * 
     */
    private String resSendtime;

    /**
     * 
     */
    private Integer resMsgid;

    /**
     * 
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
        TcsWebsocketGetQdGps other = (TcsWebsocketGetQdGps) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
            && (this.getTruckNo() == null ? other.getTruckNo() == null : this.getTruckNo().equals(other.getTruckNo()))
            && (this.getResReceiver() == null ? other.getResReceiver() == null : this.getResReceiver().equals(other.getResReceiver()))
            && (this.getResMessagetype() == null ? other.getResMessagetype() == null : this.getResMessagetype().equals(other.getResMessagetype()))
            && (this.getResSendtime() == null ? other.getResSendtime() == null : this.getResSendtime().equals(other.getResSendtime()))
            && (this.getResMsgid() == null ? other.getResMsgid() == null : this.getResMsgid().equals(other.getResMsgid()))
            && (this.getResData() == null ? other.getResData() == null : this.getResData().equals(other.getResData()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        result = prime * result + ((getTruckNo() == null) ? 0 : getTruckNo().hashCode());
        result = prime * result + ((getResReceiver() == null) ? 0 : getResReceiver().hashCode());
        result = prime * result + ((getResMessagetype() == null) ? 0 : getResMessagetype().hashCode());
        result = prime * result + ((getResSendtime() == null) ? 0 : getResSendtime().hashCode());
        result = prime * result + ((getResMsgid() == null) ? 0 : getResMsgid().hashCode());
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
        sb.append(", resReceiver=").append(resReceiver);
        sb.append(", resMessagetype=").append(resMessagetype);
        sb.append(", resSendtime=").append(resSendtime);
        sb.append(", resMsgid=").append(resMsgid);
        sb.append(", resData=").append(resData);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}