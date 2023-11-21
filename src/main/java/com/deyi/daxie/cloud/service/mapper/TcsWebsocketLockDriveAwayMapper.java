package com.deyi.daxie.cloud.service.mapper;

import com.deyi.daxie.cloud.service.bean.TcsWebsocketLockDriveAway;
import org.apache.ibatis.annotations.Mapper;

/**
* @author m1771
* @description 针对表【tcs_websocket_lock_drive_away】的数据库操作Mapper
* @createDate 2023-09-14 09:52:09
* @Entity generator.domain.TcsWebsocketLockDriveAway
*/
@Mapper
public interface TcsWebsocketLockDriveAwayMapper  {

    int add(TcsWebsocketLockDriveAway tcsWebsocketLockDriveAway);
}




