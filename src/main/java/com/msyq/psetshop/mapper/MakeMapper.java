package com.msyq.psetshop.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Date;

import com.msyq.psetshop.pojo.Make;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MakeMapper {
    int deleteByPrimaryKey(Integer mId);

    int insert(Make record);

    int insertSelective(Make record);

    Make selectByPrimaryKey(Integer mId);

    int updateByPrimaryKeySelective(Make record);

    int updateByPrimaryKey(Make record);

    List<Make> listByAll();

    List<Make> findAllByFkUId(@Param("fkUId")Integer fkUId);

    List<Make> findAllByFkUIdAndFkDId(@Param("fkUId")Integer fkUId,@Param("fkDId")Integer fkDId);



}