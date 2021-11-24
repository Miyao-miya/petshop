package com.msyq.psetshop.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.msyq.psetshop.pojo.Business;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BusinessMapper {
    int deleteByPrimaryKey(Integer bId);

    int insert(Business record);

    int insertSelective(Business record);

    Business selectByPrimaryKey(Integer bId);

    int updateByPrimaryKeySelective(Business record);

    int updateByPrimaryKey(Business record);

    List<Business> listByAll();

}