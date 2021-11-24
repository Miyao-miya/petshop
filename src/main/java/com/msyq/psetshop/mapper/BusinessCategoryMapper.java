package com.msyq.psetshop.mapper;

import com.msyq.psetshop.pojo.BusinessCategory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BusinessCategoryMapper {
    int deleteByPrimaryKey(Integer bcId);

    int insert(BusinessCategory record);

    int insertSelective(BusinessCategory record);

    BusinessCategory selectByPrimaryKey(Integer bcId);

    int updateByPrimaryKeySelective(BusinessCategory record);

    int updateByPrimaryKey(BusinessCategory record);
}