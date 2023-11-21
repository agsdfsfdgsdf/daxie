package com.deyi.daxie.cloud.service.mapper;

import com.deyi.daxie.cloud.service.bean.TcsApiLockarrive;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zyd
 * @description 针对表【tcs_api_LockArrive】的数据库操作Mapper
 * @createDate 2023-06-25 15:41:31
 * @Entity com.deyi.daxie.cloud.service.bean.TcsApiLockarrive
 */
@Mapper
public interface TcsApiLockarriveMapper {
    /**
     * 写入数据
     *
     * @param lockArrive lockArrive
     * @return int
     */
    int add(TcsApiLockarrive lockArrive);
}




