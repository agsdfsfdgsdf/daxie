package com.deyi.daxie.cloud.service.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName tcs_login
 */
@Data
public class TcsLogin implements Serializable {
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
     * 账号
     */
    private String paramUsername;

    /**
     * 密码
     */
    private String paramPassword;

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
        TcsLogin other = (TcsLogin) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
            && (this.getTruckNo() == null ? other.getTruckNo() == null : this.getTruckNo().equals(other.getTruckNo()))
            && (this.getParamUsername() == null ? other.getParamUsername() == null : this.getParamUsername().equals(other.getParamUsername()))
            && (this.getParamPassword() == null ? other.getParamPassword() == null : this.getParamPassword().equals(other.getParamPassword()))
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
        result = prime * result + ((getParamUsername() == null) ? 0 : getParamUsername().hashCode());
        result = prime * result + ((getParamPassword() == null) ? 0 : getParamPassword().hashCode());
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
        sb.append(", paramUsername=").append(paramUsername);
        sb.append(", paramPassword=").append(paramPassword);
        sb.append(", resCode=").append(resCode);
        sb.append(", resMessage=").append(resMessage);
        sb.append(", resData=").append(resData);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}