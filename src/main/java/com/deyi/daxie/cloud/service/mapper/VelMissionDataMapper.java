package com.deyi.daxie.cloud.service.mapper;

import com.deyi.daxie.cloud.service.bean.VelMissionData;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zyd
 * @description 针对表【mission_data】的数据库操作Mapper
 * @createDate 2023-05-30 16:57:03
 * @Entity generator.domain.MissionData
 */
@Mapper
public interface VelMissionDataMapper {
    /**
     * 写入数据
     *
     * @param velMissionData missionData
     * @return int
     */
    int add(VelMissionData velMissionData);
}




