package com.deyi.daxie.cloud.service.util;

import lombok.Getter;

@Getter
public enum DeviceEnum {
    NUMONE("T901", "T901","901901"),
    NUMTWO("T902", "T902","902902"),
    NUMTHREE("T903", "T903","903903"),
    NUMFOUR("T904", "T904","904904"),
    NUMFIVE("T905", "T905","905905"),
    NUMSIX("T906", "T906","906906"),
    NUMSEVEN("T907", "T907","123456"),
    NUMEIGHT("T908", "T908","123456");
    /**
     * 接口类型
     */
    private final String deviceNum;
    /**
     * 接口描述
     */
    private final String userName;
    /**
     * 接口描述
     */
    private final String passWord;
    /**
     * 构造函数
     *
     * @param deviceNum  type
     */
    DeviceEnum(String deviceNum, String userName, String passWord) {
        this.deviceNum = deviceNum;
        this.userName = userName;
        this.passWord = passWord;
    }

    /**
     * 获取值
     *
     * @return String
     */
    public String getDeviceNum() {
        return this.deviceNum;
    }

    /**
     * 获取值
     *
     * @return String
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * 获取接口描述
     *
     * @return String
     */
    public String getPassWord() {
        return this.passWord;
    }
    /**
     * @param deviceNum value
     * @return DataType
     */
    public static String getPassWord(String deviceNum) {
        for (DeviceEnum value : DeviceEnum.values()) {
            if (value.deviceNum.equals(deviceNum)) {
                return value.passWord;
            }
        }
        return null;
    }
    public static String getUserName(String deviceNum) {
        for (DeviceEnum value : DeviceEnum.values()) {
            if (value.deviceNum.equals(deviceNum)) {
                return value.userName;
            }
        }
        return null;
    }
}
