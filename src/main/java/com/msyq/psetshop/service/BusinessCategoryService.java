package com.msyq.psetshop.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.msyq.psetshop.mapper.BusinessCategoryMapper;
import com.msyq.psetshop.pojo.BusinessCategory;
@Service
public class BusinessCategoryService{

    @Resource
    private BusinessCategoryMapper businessCategoryMapper;

    
    public int deleteByPrimaryKey(Integer bcId) {
        return businessCategoryMapper.deleteByPrimaryKey(bcId);
    }

    
    public int insert(BusinessCategory record) {
        return businessCategoryMapper.insert(record);
    }

    
    public int insertSelective(BusinessCategory record) {
        return businessCategoryMapper.insertSelective(record);
    }

    
    public BusinessCategory selectByPrimaryKey(Integer bcId) {
        return businessCategoryMapper.selectByPrimaryKey(bcId);
    }

    
    public int updateByPrimaryKeySelective(BusinessCategory record) {
        return businessCategoryMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(BusinessCategory record) {
        return businessCategoryMapper.updateByPrimaryKey(record);
    }

}
