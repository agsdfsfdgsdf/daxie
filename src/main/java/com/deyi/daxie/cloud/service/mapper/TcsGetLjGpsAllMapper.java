package com.deyi.daxie.cloud.service.mapper;

import com.deyi.daxie.cloud.service.bean.TcsGetLjGpsAll;
import org.apache.ibatis.annotations.Mapper;

/**
* @author cxb
* @description 针对表【tcs_get_lj_gps_all】的数据库操作Mapper
* @createDate 2023-09-08 11:11:37
* @Entity generator.domain.TcsGetLjGpsAll
*/
@Mapper
public interface TcsGetLjGpsAllMapper {

    int add(TcsGetLjGpsAll tcsGetLjGpsAll);
}




