package com.msyq.psetshop.mapper;

import com.msyq.psetshop.pojo.Topic;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TopicMapper {
    int deleteByPrimaryKey(Integer tId);

    int insert(Topic record);

    int insertSelective(Topic record);

    Topic selectByPrimaryKey(Integer tId);

    int updateByPrimaryKeySelective(Topic record);

    int updateByPrimaryKey(Topic record);
}