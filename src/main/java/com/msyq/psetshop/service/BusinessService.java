package com.msyq.psetshop.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.msyq.psetshop.pojo.Business;
import com.msyq.psetshop.mapper.BusinessMapper;

import java.util.List;

@Service
public class BusinessService{

    @Resource
    private BusinessMapper businessMapper;

    
    public int deleteByPrimaryKey(Integer bId) {
        return businessMapper.deleteByPrimaryKey(bId);
    }

    
    public int insert(Business record) {
        return businessMapper.insert(record);
    }

    
    public int insertSelective(Business record) {
        return businessMapper.insertSelective(record);
    }

    
    public Business selectByPrimaryKey(Integer bId) {
        return businessMapper.selectByPrimaryKey(bId);
    }

    
    public int updateByPrimaryKeySelective(Business record) {
        return businessMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Business record) {
        return businessMapper.updateByPrimaryKey(record);
    }


    public PageInfo<Business> listByAll(Integer page, Integer size){
        PageHelper.startPage(page,size);
        return new PageInfo<>(businessMapper.listByAll());
    }
}
