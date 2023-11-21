package com.deyi.daxie.cloud.service.mapper;

import com.deyi.daxie.cloud.service.bean.VelStatusData;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface VelStatusDataMapper {
    /**
     * 写入数据
     * @param velStatus velStatus
     * @return int
     */
    int add(VelStatusData velStatus);
}
