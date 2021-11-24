package com.msyq.psetshop.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.msyq.psetshop.mapper.TypeMapper;
import com.msyq.psetshop.pojo.Type;

import java.util.List;

@Service
public class TypeService{

    @Resource
    private TypeMapper typeMapper;

    
    public int deleteByPrimaryKey(Integer tId) {
        return typeMapper.deleteByPrimaryKey(tId);
    }

    
    public int insert(Type record) {
        return typeMapper.insert(record);
    }

    
    public int insertSelective(Type record) {
        return typeMapper.insertSelective(record);
    }

    
    public Type selectByPrimaryKey(Integer tId) {
        return typeMapper.selectByPrimaryKey(tId);
    }

    
    public int updateByPrimaryKeySelective(Type record) {
        return typeMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Type record) {
        return typeMapper.updateByPrimaryKey(record);
    }

    public List<Type> listByAll(){
        return typeMapper.listByAll();
    }

}
