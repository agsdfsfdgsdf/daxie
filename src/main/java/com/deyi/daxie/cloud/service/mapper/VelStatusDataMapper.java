package com.deyi.daxie.cloud.service.mapper;

import com.deyi.daxie.cloud.service.bean.VelStatusData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface VelStatusDataMapper {
    /**
     * 写入数据
     * @param velStatus velStatus
     * @return int
     */
    int add(VelStatusData velStatus);

    VelStatusData queryByDevice(@Param("deviceNum") String deviceNum);

    void updateLogOut(@Param("id") Long id);
}
