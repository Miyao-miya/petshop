package com.msyq.psetshop.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.msyq.psetshop.pojo.PhotosGlance;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PhotosGlanceMapper {
    int deleteByPrimaryKey(Integer pgId);

    int insert(PhotosGlance record);

    int insertSelective(PhotosGlance record);

    PhotosGlance selectByPrimaryKey(Integer pgId);

    int updateByPrimaryKeySelective(PhotosGlance record);

    int updateByPrimaryKey(PhotosGlance record);

    Integer countByFkUId(@Param("fkUId")Integer fkUId);

   Integer countByPgTf(@Param("pgTf")Integer pgTf);

   Integer countByFkPId(@Param("fkPId")Integer fkPId);

   List<PhotosGlance> findAllByFkUIdAndFkPId(@Param("fkUId")Integer fkUId,@Param("fkPId")Integer fkPId);

   Integer countByFkPIdAndPgTf(@Param("fkPId")Integer fkPId,@Param("pgTf")Integer pgTf);

   int updateByFkUIdAndFkPId(@Param("updated")PhotosGlance updated,@Param("fkUId")Integer fkUId,@Param("fkPId")Integer fkPId);



}