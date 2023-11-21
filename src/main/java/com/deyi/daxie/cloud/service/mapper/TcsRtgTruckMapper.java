package com.deyi.daxie.cloud.service.mapper;

import com.deyi.daxie.cloud.service.bean.TcsRtgTruck;
import org.apache.ibatis.annotations.Mapper;

/**
* @author cxb
* @description 针对表【tcs_RTG_truck】的数据库操作Mapper
* @createDate 2023-09-08 09:43:20
* @Entity generator.domain.TcsRtgTruck
*/
@Mapper
public interface TcsRtgTruckMapper {

    int add(TcsRtgTruck tcsRtgTruck);
}




