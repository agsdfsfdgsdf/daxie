package com.deyi.daxie.cloud.service.mapper;

import com.deyi.daxie.cloud.service.bean.TcsQcPosition;
import org.apache.ibatis.annotations.Mapper;

/**
* @author cxb
* @description 针对表【tcs_qc_position】的数据库操作Mapper
* @createDate 2023-09-07 09:58:41
* @Entity generator.domain.TcsQcPosition
*/
@Mapper
public interface TcsQcPositionMapper{

    int add(TcsQcPosition tcsQcPosition);
}




