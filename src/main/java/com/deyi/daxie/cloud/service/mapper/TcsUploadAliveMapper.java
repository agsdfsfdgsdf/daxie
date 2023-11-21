package com.deyi.daxie.cloud.service.mapper;

import com.deyi.daxie.cloud.service.bean.TcsUploadAlive;
import org.apache.ibatis.annotations.Mapper;

/**
* @author cxb
* @description 针对表【tcs_upload_alive】的数据库操作Mapper
* @createDate 2023-09-06 10:29:34
* @Entity generator.domain.TcsUploadAlive
*/
@Mapper
public interface TcsUploadAliveMapper {

    int add(TcsUploadAlive tcsUploadAlive);
}




