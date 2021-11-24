package com.msyq.psetshop.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.msyq.psetshop.mapper.ShopCartMapper;
import com.msyq.psetshop.pojo.ShopCart;

import java.util.List;

@Service
public class ShopCartService {

    @Resource
    private ShopCartMapper shopCartMapper;


    public int deleteByPrimaryKey(Integer scId) {
        return shopCartMapper.deleteByPrimaryKey(scId);
    }


    public int insert(ShopCart record) {
        return shopCartMapper.insert(record);
    }


    public int insertSelective(ShopCart record) {
        return shopCartMapper.insertSelective(record);
    }


    public ShopCart selectByPrimaryKey(Integer scId) {
        return shopCartMapper.selectByPrimaryKey(scId);
    }


    public int updateByPrimaryKeySelective(ShopCart record) {
        return shopCartMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(ShopCart record) {
        return shopCartMapper.updateByPrimaryKey(record);
    }

    public PageInfo<ShopCart> findByAll(ShopCart shopCart, Integer page, Integer size){
        PageHelper.startPage(page, size);
        return new PageInfo<>(shopCartMapper.findByAll(shopCart));
    }

    public PageInfo<ShopCart> listByAll(Integer page,Integer size){
        PageHelper.startPage(page, size);
        return new PageInfo<>(shopCartMapper.findByAll(new ShopCart()));
    }

    public PageInfo<ShopCart> findAllByFkUId(Integer fkUId,
                                         Integer page,
                                         Integer size){
        PageHelper.startPage(page,size);
        return new PageInfo<>(shopCartMapper.findAllByFkUId(fkUId));
    }

}

