package com.msyq.psetshop.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.msyq.psetshop.pojo.Classes;
import com.msyq.psetshop.mapper.ClassesMapper;
@Service
public class ClassesService{

    @Resource
    private ClassesMapper classesMapper;

    
    public int deleteByPrimaryKey(Integer cId) {
        return classesMapper.deleteByPrimaryKey(cId);
    }

    
    public int insert(Classes record) {
        return classesMapper.insert(record);
    }

    
    public int insertSelective(Classes record) {
        return classesMapper.insertSelective(record);
    }

    
    public Classes selectByPrimaryKey(Integer cId) {
        return classesMapper.selectByPrimaryKey(cId);
    }

    
    public int updateByPrimaryKeySelective(Classes record) {
        return classesMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Classes record) {
        return classesMapper.updateByPrimaryKey(record);
    }

    public PageInfo<Classes>  listByAll(Integer page, Integer size){
        PageHelper.startPage(page, size);
        return new PageInfo<>(classesMapper.listByAll());
    }
}
