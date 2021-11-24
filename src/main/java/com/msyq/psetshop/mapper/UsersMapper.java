package com.msyq.psetshop.mapper;
import java.util.Date;

import com.msyq.psetshop.pojo.Users;
import org.apache.ibatis.annotations.Mapper;import org.apache.ibatis.annotations.Param;import java.util.List;

@Mapper
public interface UsersMapper {
    int deleteByPrimaryKey(Integer uId);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer uId);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    List<Users> listByUNote(@Param("uNote") String uNote);

    List<Users> findByAll(Users users);

    List<Users> listByAll();


}