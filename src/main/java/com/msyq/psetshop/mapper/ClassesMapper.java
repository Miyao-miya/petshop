package com.msyq.psetshop.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Date;

import com.msyq.psetshop.pojo.Classes;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClassesMapper {
    int deleteByPrimaryKey(Integer cId);

    int insert(Classes record);

    int insertSelective(Classes record);

    Classes selectByPrimaryKey(Integer cId);

    int updateByPrimaryKeySelective(Classes record);

    int updateByPrimaryKey(Classes record);

    List<Classes> listByAll();


}