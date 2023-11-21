package com.deyi.daxie.cloud.service.mapper;

import com.deyi.daxie.cloud.service.bean.TcsGetLmdGpsAll;
import org.apache.ibatis.annotations.Mapper;

/**
* @author cxb
* @description 针对表【tcs_get_lmd_gps_all】的数据库操作Mapper
* @createDate 2023-09-08 11:05:19
* @Entity generator.domain.TcsGetLmdGpsAll
*/
@Mapper
public interface TcsGetLmdGpsAllMapper{

    int add(TcsGetLmdGpsAll tcsGetLmdGpsAll);
}




