package com.msyq.psetshop.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.msyq.psetshop.pojo.Make;
import com.msyq.psetshop.mapper.MakeMapper;

import java.util.List;

@Service
public class MakeService{

    @Resource
    private MakeMapper makeMapper;

    
    public int deleteByPrimaryKey(Integer mId) {
        return makeMapper.deleteByPrimaryKey(mId);
    }

    
    public int insert(Make record) {
        return makeMapper.insert(record);
    }

    
    public int insertSelective(Make record) {
        return makeMapper.insertSelective(record);
    }

    
    public Make selectByPrimaryKey(Integer mId) {
        return makeMapper.selectByPrimaryKey(mId);
    }

    
    public int updateByPrimaryKeySelective(Make record) {
        return makeMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Make record) {
        return makeMapper.updateByPrimaryKey(record);
    }


    public PageInfo<Make> listByAll(Integer page, Integer size){
        PageHelper.startPage(page,size);
        return new PageInfo<>(makeMapper.listByAll());
    }

    public PageInfo<Make> findAllByFkUId(Integer fkUId,
                                         Integer page,
                                         Integer size){
        PageHelper.startPage(page, size);
        return new PageInfo<>(makeMapper.findAllByFkUId(fkUId));
    }

    public List<Make> findAllByFkUIdAndFkDId(Integer fkUId,
                                             Integer fkDId){
        return makeMapper.findAllByFkUIdAndFkDId(fkUId, fkDId);
    }

}
