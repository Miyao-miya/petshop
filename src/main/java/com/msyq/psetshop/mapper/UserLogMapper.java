package com.msyq.psetshop.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Date;

import com.msyq.psetshop.pojo.UserLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserLogMapper {

    int deleteByPrimaryKey(Integer ulId);

    int insert(UserLog record);

    int insertSelective(UserLog record);

    UserLog selectByPrimaryKey(Integer ulId);

    int updateByPrimaryKeySelective(UserLog record);

    int updateByPrimaryKey(UserLog record);


    List<UserLog> listByAll();



}