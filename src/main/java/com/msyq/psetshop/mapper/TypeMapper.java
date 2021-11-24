package com.msyq.psetshop.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.msyq.psetshop.pojo.Type;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TypeMapper {
    int deleteByPrimaryKey(Integer tId);

    int insert(Type record);

    int insertSelective(Type record);

    Type selectByPrimaryKey(Integer tId);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);

    List<Type> listByAll();

}