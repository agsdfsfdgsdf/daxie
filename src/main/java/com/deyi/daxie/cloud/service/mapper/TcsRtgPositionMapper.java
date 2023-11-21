package com.deyi.daxie.cloud.service.mapper;

import com.deyi.daxie.cloud.service.bean.TcsRtgPosition;
import org.apache.ibatis.annotations.Mapper;

/**
* @author cxb
* @description 针对表【tcs_RTG_position】的数据库操作Mapper
* @createDate 2023-09-08 10:05:27
* @Entity generator.domain.TcsRtgPosition
*/
@Mapper
public interface TcsRtgPositionMapper {

    int add(TcsRtgPosition tcsRtgPosition);
}




