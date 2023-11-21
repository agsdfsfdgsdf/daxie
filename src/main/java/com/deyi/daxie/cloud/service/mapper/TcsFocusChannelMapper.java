package com.deyi.daxie.cloud.service.mapper;

import com.deyi.daxie.cloud.service.bean.TcsFocusChannel;
import org.apache.ibatis.annotations.Mapper;

/**
* @author cxb
* @description 针对表【tcs_focus_channel】的数据库操作Mapper
* @createDate 2023-09-06 13:50:34
* @Entity generator.domain.TcsFocusChannel
*/
@Mapper
public interface TcsFocusChannelMapper {

    int add(TcsFocusChannel tcsFocusChannel);
}




