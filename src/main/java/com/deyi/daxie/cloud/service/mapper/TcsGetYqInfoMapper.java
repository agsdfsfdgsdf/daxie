package com.deyi.daxie.cloud.service.mapper;

import com.deyi.daxie.cloud.service.bean.TcsGetYqInfo;
import org.apache.ibatis.annotations.Mapper;

/**
* @author cxb
* @description 针对表【tcs_get_yq_info】的数据库操作Mapper
* @createDate 2023-09-07 09:04:11
* @Entity generator.domain.TcsGetYqInfo
*/
@Mapper
public interface TcsGetYqInfoMapper {

    int add(TcsGetYqInfo tcsGetYqInfo);
}




