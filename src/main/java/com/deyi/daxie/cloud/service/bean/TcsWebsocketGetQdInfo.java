package com.deyi.daxie.cloud.service.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName tcs_websocket_get_qd_info
 */
@Data
public class TcsWebsocketGetQdInfo implements Serializable {
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
     * 变化的内容
     */
    private Integer resChangedtype;

    /**
     * 桥吊id
     */
    private String resId;

    /**
     * 桥吊名称
     */
    private String resName;

    /**
     * 0 正常工作状态  1 桥吊不可用  2 桥吊关路信息
     */
    private Integer resState;

    /**
     * S20 小，S40 40尺箱，S45 45尺箱， S220 双小箱
     */
    private String resSling;

    /**
     * GPS位置  预留
     */
    private String resPosition;

    /**
     * 关路信息
     */
    private String resClosedlanes;

    /**
     * 刷新时间
     */
    private String resRefreshtime;

    /**
     * 刷新时间
     */
    private String resRefreshtimevalue;

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
        TcsWebsocketGetQdInfo other = (TcsWebsocketGetQdInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
            && (this.getTruckNo() == null ? other.getTruckNo() == null : this.getTruckNo().equals(other.getTruckNo()))
            && (this.getResChangedtype() == null ? other.getResChangedtype() == null : this.getResChangedtype().equals(other.getResChangedtype()))
            && (this.getResId() == null ? other.getResId() == null : this.getResId().equals(other.getResId()))
            && (this.getResName() == null ? other.getResName() == null : this.getResName().equals(other.getResName()))
            && (this.getResState() == null ? other.getResState() == null : this.getResState().equals(other.getResState()))
            && (this.getResSling() == null ? other.getResSling() == null : this.getResSling().equals(other.getResSling()))
            && (this.getResPosition() == null ? other.getResPosition() == null : this.getResPosition().equals(other.getResPosition()))
            && (this.getResClosedlanes() == null ? other.getResClosedlanes() == null : this.getResClosedlanes().equals(other.getResClosedlanes()))
            && (this.getResRefreshtime() == null ? other.getResRefreshtime() == null : this.getResRefreshtime().equals(other.getResRefreshtime()))
            && (this.getResRefreshtimevalue() == null ? other.getResRefreshtimevalue() == null : this.getResRefreshtimevalue().equals(other.getResRefreshtimevalue()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        result = prime * result + ((getTruckNo() == null) ? 0 : getTruckNo().hashCode());
        result = prime * result + ((getResChangedtype() == null) ? 0 : getResChangedtype().hashCode());
        result = prime * result + ((getResId() == null) ? 0 : getResId().hashCode());
        result = prime * result + ((getResName() == null) ? 0 : getResName().hashCode());
        result = prime * result + ((getResState() == null) ? 0 : getResState().hashCode());
        result = prime * result + ((getResSling() == null) ? 0 : getResSling().hashCode());
        result = prime * result + ((getResPosition() == null) ? 0 : getResPosition().hashCode());
        result = prime * result + ((getResClosedlanes() == null) ? 0 : getResClosedlanes().hashCode());
        result = prime * result + ((getResRefreshtime() == null) ? 0 : getResRefreshtime().hashCode());
        result = prime * result + ((getResRefreshtimevalue() == null) ? 0 : getResRefreshtimevalue().hashCode());
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
        sb.append(", resChangedtype=").append(resChangedtype);
        sb.append(", resId=").append(resId);
        sb.append(", resName=").append(resName);
        sb.append(", resState=").append(resState);
        sb.append(", resSling=").append(resSling);
        sb.append(", resPosition=").append(resPosition);
        sb.append(", resClosedlanes=").append(resClosedlanes);
        sb.append(", resRefreshtime=").append(resRefreshtime);
        sb.append(", resRefreshtimevalue=").append(resRefreshtimevalue);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}