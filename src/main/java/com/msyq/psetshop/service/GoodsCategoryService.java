package com.msyq.psetshop.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.msyq.psetshop.pojo.GoodsCategory;
import com.msyq.psetshop.mapper.GoodsCategoryMapper;

import java.util.List;

@Service
public class GoodsCategoryService{

    @Resource
    private GoodsCategoryMapper goodsCategoryMapper;

    
    public int deleteByPrimaryKey(Integer gcId) {
        return goodsCategoryMapper.deleteByPrimaryKey(gcId);
    }

    
    public int insert(GoodsCategory record) {
        return goodsCategoryMapper.insert(record);
    }

    
    public int insertSelective(GoodsCategory record) {
        return goodsCategoryMapper.insertSelective(record);
    }

    
    public GoodsCategory selectByPrimaryKey(Integer gcId) {
        return goodsCategoryMapper.selectByPrimaryKey(gcId);
    }

    
    public int updateByPrimaryKeySelective(GoodsCategory record) {
        return goodsCategoryMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(GoodsCategory record) {
        return goodsCategoryMapper.updateByPrimaryKey(record);
    }


    public List<GoodsCategory> findByAll(GoodsCategory goodsCategory){
        return goodsCategoryMapper.findByAll(goodsCategory);
    }

    public List<GoodsCategory> listByAll(){
        return goodsCategoryMapper.listByAll();
    }

}
