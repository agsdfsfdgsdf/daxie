package com.deyi.daxie.cloud.service.mapper;

import com.deyi.daxie.cloud.service.bean.TcsApiAction;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zyd
 * @description 针对表【tcs_api_action】的数据库操作Mapper
 * @createDate 2023-06-20 17:44:54
 * @Entity generator.domain.TcsApiAction
 */
@Mapper
public interface TcsApiActionMapper {
    /**
     * 写入数据
     *
     * @param tcsApiAction tcsApiAction
     * @return int
     */
    int add(TcsApiAction tcsApiAction);
}




