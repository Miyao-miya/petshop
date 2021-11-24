package com.msyq.psetshop.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.msyq.psetshop.pojo.Grade;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GradeMapper {
    int deleteByPrimaryKey(Integer gId);

    int insert(Grade record);

    int insertSelective(Grade record);

    Grade selectByPrimaryKey(Integer gId);

    int updateByPrimaryKeySelective(Grade record);

    int updateByPrimaryKey(Grade record);

    List<Grade> findAllByFkId(@Param("fkId")Integer fkId);


}