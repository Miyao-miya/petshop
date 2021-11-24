package com.msyq.psetshop.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Date;

import com.msyq.psetshop.pojo.Error;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ErrorMapper {
    int deleteByPrimaryKey(Integer eId);

    int insert(Error record);

    int insertSelective(Error record);

    Error selectByPrimaryKey(Integer eId);

    int updateByPrimaryKeySelective(Error record);

    int updateByPrimaryKey(Error record);

    List<Error> listByAll();

}