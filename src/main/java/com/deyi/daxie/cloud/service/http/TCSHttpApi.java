package com.deyi.daxie.cloud.service.http;

import com.alibaba.fastjson.JSONObject;
import com.deyi.daxie.cloud.service.config.HttpConfig;
import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitClient;
import org.apache.ibatis.annotations.Mapper;
import retrofit2.http.*;

import java.util.Map;

@RetrofitClient(baseUrl = "http://" + HttpConfig.TCS_BASE_URL)
@Mapper
public interface TCSHttpApi {
    @GET("api/test")
    JSONObject getTest(@Body Map<String, Object> map);

    /**
     * 3.1.1.用户登录
     *
     * @param map map
     * @return JSONObject
     */
    @POST("/websocket/login")
    JSONObject login(@Header("satoken") String token, @Body Map<String, Object> map);

    /**
     * 3.1.2.用户退出
     *
     * @param map map
     * @return JSONObject
     */
    @POST("/websocket/logout")
    JSONObject logout(@Header("satoken") String token, @Body Map<String, Object> map);

    /**
     * 3.1.3.上传心跳
     *
     * @param map map
     * @return JSONObject
     */
    @POST("/websocket/upload-alive")
    JSONObject alive(@Header("satoken") String token, @Body Map<String, Object> map);

    /**
     * 3.1.4.上传集卡状态
     *
     * @param map map
     * @return JSONObject
     */
    @POST("/websocket/upload-truck-status")
    JSONObject uploadTruckStatus(@Header("satoken") String token, @Body Map<String, Object> map);

    /**
     * 3.1.5.获取LED显示的内容
     *
     * @param map map
     * @return JSONObject
     */
    @GET("/websocket/get-led-message")
    JSONObject getLedMessage(@Header("satoken") String token, @QueryMap Map<String, Object> map);

    /**
     * 3.1.6.查询最新的指令信息
     *
     * @param map map
     * @return JSONObject
     */
    @GET("/websocket/getInstructions")
    JSONObject getInstructions(@Header("satoken") String token, @QueryMap Map<String, Object> map);

    /**
     * 3.1.7.业务信息订阅
     *
     * @param map map
     * @return JSONObject
     */
    @POST("/websocket/focus-channel")
    JSONObject focusChannel(@Header("satoken") String token, @Body Map<String, Object> map);

    /**
     * 3.2.1.获取上下引桥数据
     *
     * @param map map
     * @return JSONObject
     */
    @GET("/websocket/get-yq-info")
    JSONObject getYqInfo(@Header("satoken") String token, @QueryMap Map<String, Object> map);

    /**
     * 3.2.2.理货上报车号功能
     *
     * @param map map
     * @return JSONObject
     */
    @POST("/websocket/upload-truck-no-to-li-huo")
    JSONObject uploadTruckLiHuo(@Header("satoken") String token, @Body Map<String, Object> map);

    /**
     * 3.2.3.桥吊下集卡到位
     *
     * @param map map
     * @return JSONObject
     */
    @POST("/websocket/TCS_QC/position")
    JSONObject tcsQcPosition(@Header("satoken") String token, @Body Map<String, Object> map);

    /**
     * 3.2.4.获取桥吊作业车道数据
     * @param token
     * @return
     */
    @GET("/websocket/get-qd-lane-info")
    JSONObject getQdLaneInfo(@Header("satoken") String token);

    /**
     * 3.2.5.获取所有桥吊GPS数据
     * @param token
     * @return
     */
    @GET("/websocket/get-qd-gps-all")
    JSONObject getQdGpsAll(@Header("satoken") String token);

    /**
     * 3.2.6.发送提示信息至桥吊
     *
     * @param map map
     * @return JSONObject
     */
    @POST("/websocket/send-notice")
    JSONObject sendNotice(@Header("satoken") String token, @Body Map<String, Object> map);

    /**
     * 3.2.7.无人集卡桥吊下对位完成信息
     *
     * @param map map
     * @return JSONObject
     */
    @POST("/websocket/TruckToTcs/confirmQcCpsEnd")
    JSONObject confirmQcCpsEnd(@Header("satoken") String token, @Body Map<String, Object> map);

    /**
     * 3.3.1.无人集卡进出栏申请
     *
     * @param map map
     * @return JSONObject
     */
    @POST("/websocket/TCS_RTG/truck")
    JSONObject tcsRtgTruck(@Header("satoken") String token, @Body Map<String, Object> map);

    /**
     * 3.3.2.无人集卡堆场内借道申请
     *
     * @param map map
     * @return JSONObject
     */
    @POST("/websocket/TCS_RTG/change_road")
    JSONObject changeRoad(@Header("satoken") String token, @Body Map<String, Object> map);

    /**
     * 3.3.3.无人集卡堆场内到位上报
     *
     * @param map map
     * @return JSONObject
     */
    @POST("/websocket/TCS_RTG/position")
    JSONObject uploadPosition(@Header("satoken") String token, @Body Map<String, Object> map);

    /**
     * 3.3.4.无人集卡堆场内接收对位信息完成
     *
     * @param map map
     * @return JSONObject
     */
    @POST("/websocket/TCS_RTG/confirmCpsStop")
    JSONObject confirmCpsStop(@Header("satoken") String token, @Body Map<String, Object> map);

    /**
     * 3.3.5.获取所有龙门吊GPS数据
     * @param token
     * @return
     */
    @GET("/websocket/get-lmd-gps-all")
    JSONObject getLmdGpsAll(@Header("satoken") String token);

    /**
     * 3.3.6.获取所有流机GPS数据
     * @param token
     * @return
     */
    @GET("/websocket/get-lj-gps-all")
    JSONObject getLjGpsAll(@Header("satoken") String token);

    /**
     * 3.3.9 无人集卡在装卸锁下到位接口
     *
     * @param map map
     * @return JSONObject
     */
    @POST("/websocket/api/LockArrive")
    JSONObject lockArrive(@Header("satoken") String token, @Body Map<String, Object> map);

    /**
     * 3.1.8.查询TOS集卡在线状态
     *
     * @param map map
     * @return JSONObject
     */
    @GET("/websocket/api/getOnlineStatus")
    JSONObject getOnlineStatus(@Header("satoken") String token, @QueryMap Map<String, Object> map);

    /**
     * 3.1.9.获取集卡GPS数据
     *
     * @param map map
     * @return JSONObject
     */
    @GET("/websocket/get-jk-gps-all")
    JSONObject getJkGpsAll(@Header("satoken") String token, @QueryMap Map<String, Object> map);

    /**
     * 3.3.10. 查询集卡是否需要装卸锁
     *
     * @param map map
     * @return JSONObject
     */
    @GET("/websocket/api/getTruckUnlock")
    JSONObject getTruckUnlock(@Header("satoken") String token, @QueryMap Map<String, Object> map);
}
