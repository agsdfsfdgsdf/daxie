package com.deyi.daxie.cloud.service.mapper;

import com.deyi.daxie.cloud.service.bean.TcsGetQdGpsAll;
import org.apache.ibatis.annotations.Mapper;

/**
* @author cxb
* @description 针对表【tcs_get_qd_gps_all】的数据库操作Mapper
* @createDate 2023-09-07 10:26:42
* @Entity generator.domain.TcsGetQdGpsAll
*/
@Mapper
public interface TcsGetQdGpsAllMapper{

    int add(TcsGetQdGpsAll tcsGetQdGpsAll);
}




