package com.deyi.daxie.cloud.service.mapper;

import com.deyi.daxie.cloud.service.bean.TcsRtgChangeRoad;
import org.apache.ibatis.annotations.Mapper;

/**
* @author cxb
* @description 针对表【tcs_RTG_change_road】的数据库操作Mapper
* @createDate 2023-09-08 09:55:31
* @Entity generator.domain.TcsRtgChangeRoad
*/
@Mapper
public interface TcsRtgChangeRoadMapper {

    int add(TcsRtgChangeRoad tcsRtgChangeRoad);
}




