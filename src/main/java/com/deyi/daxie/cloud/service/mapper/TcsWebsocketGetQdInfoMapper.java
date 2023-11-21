package com.deyi.daxie.cloud.service.mapper;

import com.deyi.daxie.cloud.service.bean.TcsWebsocketGetQdInfo;
import org.apache.ibatis.annotations.Mapper;

/**
* @author m1771
* @description 针对表【tcs_websocket_get_qd_info】的数据库操作Mapper
* @createDate 2023-09-11 17:32:19
* @Entity generator.domain.TcsWebsocketGetQdInfo
*/
@Mapper
public interface TcsWebsocketGetQdInfoMapper {
    int add(TcsWebsocketGetQdInfo tcsWebsocketGetQdInfo);
}




