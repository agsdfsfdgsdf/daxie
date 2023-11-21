package com.deyi.daxie.cloud.service.mapper;

import com.deyi.daxie.cloud.service.bean.TcsWebsocketGetQdGps;
import org.apache.ibatis.annotations.Mapper;

/**
* @author m1771
* @description 针对表【tcs_websocket_get_qd_gps】的数据库操作Mapper
* @createDate 2023-09-11 17:18:31
* @Entity generator.domain.TcsWebsocketGetQdGps
*/
@Mapper
public interface TcsWebsocketGetQdGpsMapper {
    int add(TcsWebsocketGetQdGps tcsWebsocketGetQdGps);
}




