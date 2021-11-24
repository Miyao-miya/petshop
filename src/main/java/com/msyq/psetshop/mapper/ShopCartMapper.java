package com.msyq.psetshop.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.msyq.psetshop.pojo.ShopCart;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShopCartMapper {
    int deleteByPrimaryKey(Integer scId);

    int insert(ShopCart record);

    int insertSelective(ShopCart record);

    ShopCart selectByPrimaryKey(Integer scId);

    int updateByPrimaryKeySelective(ShopCart record);

    int updateByPrimaryKey(ShopCart record);

    List<ShopCart> findByAll(ShopCart shopCart);

    List<ShopCart> listByAll(ShopCart shopCart);

    List<ShopCart> findAllByFkUId(@Param("fkUId")Integer fkUId);



}