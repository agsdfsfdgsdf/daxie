package com.deyi.daxie.cloud.service.mapper;

import com.deyi.daxie.cloud.service.bean.TcsSendNotice;
import org.apache.ibatis.annotations.Mapper;

/**
* @author cxb
* @description 针对表【tcs_send_notice】的数据库操作Mapper
* @createDate 2023-09-07 10:34:29
* @Entity generator.domain.TcsSendNotice
*/
@Mapper
public interface TcsSendNoticeMapper {

    int add(TcsSendNotice tcsSendNotice);
}




