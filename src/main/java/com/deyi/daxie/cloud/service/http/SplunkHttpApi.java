package com.deyi.daxie.cloud.service.http;

import com.alibaba.fastjson.JSONObject;
import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitClient;
import org.apache.ibatis.annotations.Mapper;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.Map;

@RetrofitClient(baseUrl = "http://10.1.6.58")
@Mapper
public interface SplunkHttpApi {
    @POST("api/StatusData")
    JSONObject uploadStatusData(@Body Map<String, Object> map);

    @POST("api/MissionData")
    JSONObject uploadMissionData(@Body Map<String, Object> map);

    @POST("api/ObstacleData")
    JSONObject uploadObstacleData(@Body Map<String, Object> map);

    @POST("api/WarnData")
    JSONObject uploadWarnData(@Body Map<String, Object> map);

    @POST("api/ControlData")
    JSONObject uploadControlData(@Body Map<String, Object> map);

    @POST("api/AligningData")
    JSONObject uploadAligningData(@Body Map<String, Object> map);
}
