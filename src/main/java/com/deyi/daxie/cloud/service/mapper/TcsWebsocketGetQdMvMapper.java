package com.deyi.daxie.cloud.service.mapper;

import com.deyi.daxie.cloud.service.bean.TcsWebsocketGetQdMv;
import org.apache.ibatis.annotations.Mapper;

/**
* @author m1771
* @description 针对表【tcs_websocket_get_qd_mv】的数据库操作Mapper
* @createDate 2023-09-13 17:55:33
* @Entity generator.domain.TcsWebsocketGetQdMv
*/
@Mapper
public interface TcsWebsocketGetQdMvMapper {

    int add(TcsWebsocketGetQdMv tcsWebsocketGetQdMv);
}




