package com.msyq.psetshop.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.msyq.psetshop.mapper.UserLogMapper;
import com.msyq.psetshop.pojo.UserLog;

import java.util.List;

@Service
public class UserLogService{

    @Resource
    private UserLogMapper userLogMapper;

    
    public int deleteByPrimaryKey(Integer ulId) {
        return userLogMapper.deleteByPrimaryKey(ulId);
    }

    
    public int insert(UserLog record) {
        return userLogMapper.insert(record);
    }

    
    public int insertSelective(UserLog record) {
        return userLogMapper.insertSelective(record);
    }

    
    public UserLog selectByPrimaryKey(Integer ulId) {
        return userLogMapper.selectByPrimaryKey(ulId);
    }

    
    public int updateByPrimaryKeySelective(UserLog record) {
        return userLogMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(UserLog record) {
        return userLogMapper.updateByPrimaryKey(record);
    }

    public PageInfo<UserLog> listByAll(Integer page,
                                       Integer size){
        PageHelper.startPage(page, size);
        return new PageInfo<>(userLogMapper.listByAll());
    }

}
