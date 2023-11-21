package com.deyi.daxie.cloud.service.mapper;

import com.deyi.daxie.cloud.service.bean.TcsWebsocketTruckDriveAway;
import org.apache.ibatis.annotations.Mapper;

/**
* @author m1771
* @description 针对表【tcs_websocket_truck_drive_away】的数据库操作Mapper
* @createDate 2023-09-14 09:07:47
* @Entity generator.domain.TcsWebsocketTruckDriveAway
*/
@Mapper
public interface TcsWebsocketTruckDriveAwayMapper  {

    int add(TcsWebsocketTruckDriveAway tcsWebsocketTruckDriveAway);
}




