package com.msyq.psetshop.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.msyq.psetshop.mapper.AdimLogMapper;
import com.msyq.psetshop.pojo.AdimLog;

import java.util.List;

@Service
public class AdimLogService{

    @Resource
    private AdimLogMapper adimLogMapper;

    
    public int deleteByPrimaryKey(Integer alId) {
        return adimLogMapper.deleteByPrimaryKey(alId);
    }

    
    public int insert(AdimLog record) {
        return adimLogMapper.insert(record);
    }

    
    public int insertSelective(AdimLog record) {
        return adimLogMapper.insertSelective(record);
    }

    
    public AdimLog selectByPrimaryKey(Integer alId) {
        return adimLogMapper.selectByPrimaryKey(alId);
    }

    
    public int updateByPrimaryKeySelective(AdimLog record) {
        return adimLogMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(AdimLog record) {
        return adimLogMapper.updateByPrimaryKey(record);
    }

    public PageInfo<AdimLog> listByAll(Integer page, Integer size){
        PageHelper.startPage(page,size);
        return new PageInfo<>(adimLogMapper.listByAll());
    }

}
