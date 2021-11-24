package com.msyq.psetshop.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Date;

import com.msyq.psetshop.pojo.Orders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrdersMapper {
    int deleteByPrimaryKey(Integer oId);

    int insert(Orders record);

    int insertSelective(Orders record);

    int insertSelectiveCopy(Orders record);

    Orders selectByPrimaryKey(Integer oId);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);

    List<Orders> listByAll();

    List<Orders> findAllByFkUId(@Param("fkUId")Integer fkUId);


    List<Orders> findAllByFkUIdIng(@Param("fkUId")Integer fkUId);

    List<Orders> findAllByFkUIdEd(@Param("fkUId")Integer fkUId);

}