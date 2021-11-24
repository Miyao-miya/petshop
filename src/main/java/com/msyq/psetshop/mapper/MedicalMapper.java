package com.msyq.psetshop.mapper;
import java.util.Date;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.msyq.psetshop.pojo.Medical;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MedicalMapper {
    int deleteByPrimaryKey(Integer mId);

    int insert(Medical record);

    int insertSelective(Medical record);

    Medical selectByPrimaryKey(Integer mId);

    int updateByPrimaryKeySelective(Medical record);

    int updateByPrimaryKey(Medical record);

    List<Medical> findAllByFkUId(@Param("fkUId")Integer fkUId);

    List<Medical> findAllByFkDId(@Param("fkDId")Integer fkDId);

    List<Medical> listByAll();

    List<Medical> findAllByFkUIdAndFkDId(@Param("fkUId")Integer fkUId,@Param("fkDId")Integer fkDId);


}