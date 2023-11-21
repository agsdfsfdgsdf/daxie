package com.deyi.daxie.cloud.service.mapper;

import com.deyi.daxie.cloud.service.bean.TcsUploadTruckStatus;
import org.apache.ibatis.annotations.Mapper;

/**
* @author cxb
* @description 针对表【tcs_upload_truck_status】的数据库操作Mapper
* @createDate 2023-09-05 14:59:55
* @Entity generator.domain.TcsUploadTruckStatus
*/
@Mapper
public interface TcsUploadTruckStatusMapper {

    int add(TcsUploadTruckStatus tcsUploadTruckStatus);
}




