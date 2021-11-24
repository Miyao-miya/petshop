package com.msyq.psetshop.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.msyq.psetshop.pojo.GoodsCategory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsCategoryMapper {
    int deleteByPrimaryKey(Integer gcId);

    int insert(GoodsCategory record);

    int insertSelective(GoodsCategory record);

    GoodsCategory selectByPrimaryKey(Integer gcId);

    int updateByPrimaryKeySelective(GoodsCategory record);

    int updateByPrimaryKey(GoodsCategory record);

    List<GoodsCategory> findByAll(GoodsCategory goodsCategory);

    List<GoodsCategory> listByAll();




}