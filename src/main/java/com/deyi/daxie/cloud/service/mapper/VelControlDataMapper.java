package com.deyi.daxie.cloud.service.mapper;

import com.deyi.daxie.cloud.service.bean.VelControlData;
import org.apache.ibatis.annotations.Mapper;

/**
* @author zyd
* @description 针对表【control_data】的数据库操作Mapper
* @createDate 2023-05-30 14:56:30
* @Entity generator.domain.ControlData
*/
@Mapper
public interface VelControlDataMapper {
    /**
     * 写入数据
     * @param velControlData controlData
     * @return int
     */
    int add(VelControlData velControlData);
}




