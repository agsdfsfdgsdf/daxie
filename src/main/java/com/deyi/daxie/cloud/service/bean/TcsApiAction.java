package com.deyi.daxie.cloud.service.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName tcs_api_action
 */
@Data
public class TcsApiAction implements Serializable {
    /**
     * 主键，自增
     */
    private Long id;

    /**
     * 请求时间
     */
    private String time;

    /**
     * 发出请求的集卡号
     */
    private String truckNo;

    /**
     * 请求token
     */
    private String token;

    /**
     * 
     */
    private String paramMessageInfo;

    /**
     * 
     */
    private String paramRtgInfo;

    /**
     * 
     */
    private String paramSpreaderInfo;

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
        TcsApiAction other = (TcsApiAction) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
            && (this.getTruckNo() == null ? other.getTruckNo() == null : this.getTruckNo().equals(other.getTruckNo()))
            && (this.getToken() == null ? other.getToken() == null : this.getToken().equals(other.getToken()))
            && (this.getParamMessageInfo() == null ? other.getParamMessageInfo() == null : this.getParamMessageInfo().equals(other.getParamMessageInfo()))
            && (this.getParamRtgInfo() == null ? other.getParamRtgInfo() == null : this.getParamRtgInfo().equals(other.getParamRtgInfo()))
            && (this.getParamSpreaderInfo() == null ? other.getParamSpreaderInfo() == null : this.getParamSpreaderInfo().equals(other.getParamSpreaderInfo()))
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
        result = prime * result + ((getParamMessageInfo() == null) ? 0 : getParamMessageInfo().hashCode());
        result = prime * result + ((getParamRtgInfo() == null) ? 0 : getParamRtgInfo().hashCode());
        result = prime * result + ((getParamSpreaderInfo() == null) ? 0 : getParamSpreaderInfo().hashCode());
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
        sb.append(", paramMessageInfo=").append(paramMessageInfo);
        sb.append(", paramRtgInfo=").append(paramRtgInfo);
        sb.append(", paramSpreaderInfo=").append(paramSpreaderInfo);
        sb.append(", resCode=").append(resCode);
        sb.append(", resMessage=").append(resMessage);
        sb.append(", resData=").append(resData);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}