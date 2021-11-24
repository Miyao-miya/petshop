package com.msyq.psetshop.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Date;

import com.msyq.psetshop.pojo.PhotoCollect;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PhotoCollectMapper {
    int deleteByPrimaryKey(Integer pcId);

    int insert(PhotoCollect record);

    int insertSelective(PhotoCollect record);

    PhotoCollect selectByPrimaryKey(Integer pcId);

    int updateByPrimaryKeySelective(PhotoCollect record);

    int updateByPrimaryKey(PhotoCollect record);

    List<PhotoCollect> findByAll(PhotoCollect photoCollect);

    List<PhotoCollect> listByAll();

    List<PhotoCollect> findAllByFkUIdAndFkPgId(@Param("fkUId")Integer fkUId,@Param("fkPgId")Integer fkPgId);

    Integer countByFkUIdAndFkPgId(@Param("fkUId")Integer fkUId,@Param("fkPgId")Integer fkPgId);

    Integer countByFkPgId(@Param("fkPgId")Integer fkPgId);

    int updateByFkUIdAndFkPgId(@Param("updated")PhotoCollect updated,@Param("fkUId")Integer fkUId,@Param("fkPgId")Integer fkPgId);

    int deleteByFkUIdAndFkPgId(@Param("fkUId")Integer fkUId,@Param("fkPgId")Integer fkPgId);



}