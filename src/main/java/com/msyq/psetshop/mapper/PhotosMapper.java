package com.msyq.psetshop.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Date;

import com.msyq.psetshop.pojo.Photos;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PhotosMapper {

    int deleteByPrimaryKey(Integer pId);

    int insert(Photos record);

    int insertSelective(Photos record);

    Photos selectByPrimaryKey(Integer pId);

    int updateByPrimaryKeySelective(Photos record);

    int updateByPrimaryKey(Photos record);

    List<Photos> findByAll(Photos photos);

    List<Photos> listByAll();

    List<Photos> findAllByFkUId(@Param("fkUId")Integer fkUId);

    List<Photos> findAllByFkUIdGroupCollect(@Param("fkUId")Integer fkUId);

    List<Photos> findAllByFkUIdGroupLike(@Param("fkUId")Integer fkUId);

}