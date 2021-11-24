package com.msyq.psetshop.mapper;

import com.msyq.psetshop.pojo.Adim;
import org.apache.ibatis.annotations.Mapper;import org.apache.ibatis.annotations.Param;import java.util.List;

@Mapper
public interface AdimMapper {
    int deleteByPrimaryKey(Integer aId);

    int insert(Adim record);

    int insertSelective(Adim record);

    Adim selectByPrimaryKey(Integer aId);

    int updateByPrimaryKeySelective(Adim record);

    int updateByPrimaryKey(Adim record);

    List<Adim> findAllByAIdAndAPassword(@Param("aId") Integer aId, @Param("aPassword") Integer aPassword);

    List<Adim> findAllByARoot(@Param("aRoot") String aRoot);
}