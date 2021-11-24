package com.msyq.psetshop.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Date;

import com.msyq.psetshop.pojo.AdimLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdimLogMapper {
    int deleteByPrimaryKey(Integer alId);

    int insert(AdimLog record);

    int insertSelective(AdimLog record);

    AdimLog selectByPrimaryKey(Integer alId);

    int updateByPrimaryKeySelective(AdimLog record);

    int updateByPrimaryKey(AdimLog record);

    List<AdimLog> listByAll();

}