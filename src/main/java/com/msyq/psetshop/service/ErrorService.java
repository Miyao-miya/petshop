package com.msyq.psetshop.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.msyq.psetshop.pojo.AdimLog;
import com.msyq.psetshop.vo.ErrorVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.msyq.psetshop.mapper.ErrorMapper;
import com.msyq.psetshop.pojo.Error;

@Service
public class ErrorService {

    @Resource
    private ErrorMapper errorMapper;


    public int deleteByPrimaryKey(Integer eId) {
        return errorMapper.deleteByPrimaryKey(eId);
    }


    public int insert(Error record) {
        return errorMapper.insert(record);
    }


    public int insertSelective(Error record) {
        return errorMapper.insertSelective(record);
    }


    public Error selectByPrimaryKey(Integer eId) {
        return errorMapper.selectByPrimaryKey(eId);
    }


    public int updateByPrimaryKeySelective(Error record) {
        return errorMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(Error record) {
        return errorMapper.updateByPrimaryKey(record);
    }

    public PageInfo<Error> listByAll(Integer page, Integer size){
        PageHelper.startPage(page,size);
        return new PageInfo<>(errorMapper.listByAll());
    }

}
