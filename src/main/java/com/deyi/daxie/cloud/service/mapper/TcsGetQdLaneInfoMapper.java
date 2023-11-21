package com.deyi.daxie.cloud.service.mapper;

import com.deyi.daxie.cloud.service.bean.TcsGetQdLaneInfo;
import org.apache.ibatis.annotations.Mapper;

/**
* @author cxb
* @description 针对表【tcs_get_qd_lane_info】的数据库操作Mapper
* @createDate 2023-09-07 10:16:49
* @Entity generator.domain.TcsGetQdLaneInfo
*/
@Mapper
public interface TcsGetQdLaneInfoMapper {

    int add(TcsGetQdLaneInfo tcsGetQdLaneInfo);
}




