package com.msyq.psetshop.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.msyq.psetshop.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsMapper {
    int deleteByPrimaryKey(Integer gId);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer gId);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    List<Goods> findByAll(Goods goods);

    List<Goods> findAllByFkGcId(@Param("fkGcId")String fkGcId);

    List<Goods> findAllByFkTypeId(@Param("fkTypeId")String fkTypeId);

    List<Goods> findAllByGName(@Param("gName")String gName);

}