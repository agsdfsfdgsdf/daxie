package com.deyi.daxie.cloud.service.mapper;

import com.deyi.daxie.cloud.service.bean.VelWarnData;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zyd
 * @description 针对表【warn_data】的数据库操作Mapper
 * @createDate 2023-05-30 18:30:14
 * @Entity generator.domain.WarnData
 */
@Mapper
public interface VelWarnDataMapper {
    /**
     * 写入数据
     * @param velStatus velStatus
     * @return int
     */
    int add(VelWarnData velWarnData);
}




