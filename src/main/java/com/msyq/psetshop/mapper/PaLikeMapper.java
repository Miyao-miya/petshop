package com.msyq.psetshop.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.msyq.psetshop.pojo.PaLike;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaLikeMapper {
    int deleteByPrimaryKey(Integer palId);

    int insert(PaLike record);

    int insertSelective(PaLike record);

    PaLike selectByPrimaryKey(Integer palId);

    int updateByPrimaryKeySelective(PaLike record);

    int updateByPrimaryKey(PaLike record);

    List<PaLike> selectAllByFkPaId(@Param("fkPaId")Integer fkPaId);


}