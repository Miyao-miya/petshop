package com.msyq.psetshop.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.msyq.psetshop.mapper.OrdersMapper;
import com.msyq.psetshop.pojo.Orders;

import java.util.List;

@Service
public class OrdersService{

    @Resource
    private OrdersMapper ordersMapper;

    
    public int deleteByPrimaryKey(Integer oId) {
        return ordersMapper.deleteByPrimaryKey(oId);
    }

    
    public int insert(Orders record) {
        return ordersMapper.insert(record);
    }

    
    public int insertSelective(Orders record) {
        return ordersMapper.insertSelective(record);
    }

    
    public Orders selectByPrimaryKey(Integer oId) {
        return ordersMapper.selectByPrimaryKey(oId);
    }

    
    public int updateByPrimaryKeySelective(Orders record) {
        return ordersMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Orders record) {
        return ordersMapper.updateByPrimaryKey(record);
    }


    public PageInfo<Orders> listByAll(Integer page, Integer size){
        PageHelper.startPage(page,size);
        return new PageInfo<>(ordersMapper.listByAll());
    }

    public PageInfo<Orders> findAllByFkUId(Integer fkUId,
                                           Integer page,
                                           Integer size){
        PageHelper.startPage(page, size);
        return new PageInfo<>(ordersMapper.findAllByFkUId(fkUId));
    }

    public PageInfo<Orders> findAllByFkUIdIng(Integer fkUId,
                                              Integer page,
                                              Integer size){

        PageHelper.startPage(page, size);
        return new PageInfo<>(ordersMapper.findAllByFkUIdIng(fkUId));
    }

    public PageInfo<Orders> findAllByFkUIdEd(Integer fkUId,
                                              Integer page,
                                              Integer size){

        PageHelper.startPage(page, size);
        return new PageInfo<>(ordersMapper.findAllByFkUIdEd(fkUId));
    }


    public int insertSelectiveCopy(Orders record){
        return ordersMapper.insertSelectiveCopy(record);
    }

}
