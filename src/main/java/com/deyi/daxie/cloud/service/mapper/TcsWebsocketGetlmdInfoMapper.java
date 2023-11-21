package com.deyi.daxie.cloud.service.mapper;

import com.deyi.daxie.cloud.service.bean.TcsWebsocketGetlmdInfo;
import org.apache.ibatis.annotations.Mapper;

/**
* @author m1771
* @description 针对表【tcs_websocket_get_zl_info】的数据库操作Mapper
* @createDate 2023-09-13 17:37:16
* @Entity generator.domain.TcsWebsocketGetZlInfo
*/
@Mapper
public interface TcsWebsocketGetlmdInfoMapper {

    int add(TcsWebsocketGetlmdInfo tcsWebsocketGetlmdInfo);
}




