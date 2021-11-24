package com.msyq.psetshop.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.msyq.psetshop.mapper.GoodsMapper;
import com.msyq.psetshop.pojo.Goods;

import java.util.List;

@Service
public class GoodsService {

    @Resource
    private GoodsMapper goodsMapper;


    public int deleteByPrimaryKey(Integer gId) {
        return goodsMapper.deleteByPrimaryKey(gId);
    }


    public int insert(Goods record) {
        return goodsMapper.insert(record);
    }


    public int insertSelective(Goods record) {
        return goodsMapper.insertSelective(record);
    }


    public Goods selectByPrimaryKey(Integer gId) {
        return goodsMapper.selectByPrimaryKey(gId);
    }


    public int updateByPrimaryKeySelective(Goods record) {
        return goodsMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(Goods record) {
        return goodsMapper.updateByPrimaryKey(record);
    }

    public PageInfo<Goods> findAll(Goods goods, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        return new PageInfo<Goods>(goodsMapper.findByAll(goods));
    }

    public PageInfo<Goods> findAllByFkGcId(String fkGcId, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        return new PageInfo<Goods>(goodsMapper.findAllByFkGcId(fkGcId));
    }

    public PageInfo<Goods> findAllByFkTypeId(String fkTypeId, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        return new PageInfo<>(goodsMapper.findAllByFkTypeId(fkTypeId));
    }

    public PageInfo<Goods> findAllByGName(String gName){
        return new PageInfo<>(goodsMapper.findAllByGName(gName));
    }
}
