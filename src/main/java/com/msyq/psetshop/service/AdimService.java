package com.msyq.psetshop.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.msyq.psetshop.mapper.AdimMapper;
import com.msyq.psetshop.pojo.Adim;

import java.util.List;

@Service
public class AdimService {

    @Resource
    private AdimMapper adimMapper;


    public int deleteByPrimaryKey(Integer aId) {
        return adimMapper.deleteByPrimaryKey(aId);
    }


    public int insert(Adim record) {
        return adimMapper.insert(record);
    }


    public int insertSelective(Adim record) {
        return adimMapper.insertSelective(record);
    }


    public Adim selectByPrimaryKey(Integer aId) {
        return adimMapper.selectByPrimaryKey(aId);
    }


    public int updateByPrimaryKeySelective(Adim record) {
        return adimMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(Adim record) {
        return adimMapper.updateByPrimaryKey(record);
    }

    public List<Adim> findAllByAIdAndAPassword(Integer aId, Integer aPassword){
        return adimMapper.findAllByAIdAndAPassword(aId, aPassword);
    }

    public PageInfo<Adim> findAllByARoot(String aRoot,Integer page, Integer size){
        PageHelper.startPage(page, size);
        return new PageInfo<>(adimMapper.findAllByARoot(aRoot));
    }
}

