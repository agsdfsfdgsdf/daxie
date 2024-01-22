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
    private int loginStatus;

    /**
     * 作业模式，自动驾驶：0；人工驾驶：1；未登录：默认为-1
     */
    private int operationMode;

    /**
     * 版本号，当前发布的版本号
     */
    private String version;

    /**
     * 时间，yyyy-MM-dd HH:mm:ss
     */
    private String deviceTime;

    private static final long serialVersionUID = 1L;

}