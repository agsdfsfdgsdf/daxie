package com.deyi.daxie.cloud.service.mapper;
import com.deyi.daxie.cloud.service.bean.TcsLogin;
import org.apache.ibatis.annotations.Mapper;

/**
* @author cxb
* @description 针对表【tcs_login】的数据库操作Mapper
* @createDate 2023-09-05 13:52:24
* @Entity generator.domain.TcsLogin
*/
@Mapper
public interface TcsLoginMapper {

    int add(TcsLogin tcsLogin);
}




