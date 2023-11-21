package com.deyi.daxie.cloud.service.mapper;

import com.deyi.daxie.cloud.service.bean.VelAligningData;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zyd
 * @description 针对表【aligning_data】的数据库操作Mapper
 * @createDate 2023-05-30 19:25:26
 * @Entity com.deyi.daxie.cloud.service.bean.AligningData
 */
@Mapper
public interface VelAligningDataMapper {
    /**
     * 写入数据
     *
     * @param velAligningData aligningData
     * @return int
     */
    int add(VelAligningData velAligningData);
}




