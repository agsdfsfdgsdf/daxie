package com.deyi.daxie.cloud.service.mapper;

import com.deyi.daxie.cloud.service.bean.TcsGetLedMessage;
import org.apache.ibatis.annotations.Mapper;

/**
* @author cxb
* @description 针对表【tcs_get_led_message】的数据库操作Mapper
* @createDate 2023-09-06 13:23:42
* @Entity generator.domain.TcsGetLedMessage
*/
@Mapper
public interface TcsGetLedMessageMapper {

    int add(TcsGetLedMessage tcsGetLedMessage);
}




