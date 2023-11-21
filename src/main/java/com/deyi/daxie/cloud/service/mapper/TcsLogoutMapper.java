package com.deyi.daxie.cloud.service.mapper;

import com.deyi.daxie.cloud.service.bean.TcsLogout;
import org.apache.ibatis.annotations.Mapper;

/**
* @author cxb
* @description 针对表【tcs_logout】的数据库操作Mapper
* @createDate 2023-09-05 14:35:17
* @Entity generator.domain.TcsLogout
*/
@Mapper
public interface TcsLogoutMapper {

    int add(TcsLogout tcsLogout);
}




