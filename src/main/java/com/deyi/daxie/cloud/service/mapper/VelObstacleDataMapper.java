package com.deyi.daxie.cloud.service.mapper;

import com.deyi.daxie.cloud.service.bean.VelObstacleData;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zyd
 * @description 针对表【vel_obstacle_data】的数据库操作Mapper
 * @createDate 2023-07-05 16:19:09
 * @Entity generator.domain.VelObstacleData
 */
@Mapper
public interface VelObstacleDataMapper {
    /**
     * 写入数据
     *
     * @param velObstacleData velObstacleData
     * @return int
     */
    int add(VelObstacleData velObstacleData);
}




