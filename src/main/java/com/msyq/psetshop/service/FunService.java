package com.msyq.psetshop.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.msyq.psetshop.mapper.FunMapper;
import com.msyq.psetshop.pojo.Fun;

import java.util.List;

@Service
public class FunService{

    @Resource
    private FunMapper funMapper;

    
    public int deleteByPrimaryKey(Integer fId) {
        return funMapper.deleteByPrimaryKey(fId);
    }

    
    public int insert(Fun record) {
        return funMapper.insert(record);
    }

    
    public int insertSelective(Fun record) {
        return funMapper.insertSelective(record);
    }

    
    public Fun selectByPrimaryKey(Integer fId) {
        return funMapper.selectByPrimaryKey(fId);
    }

    
    public int updateByPrimaryKeySelective(Fun record) {
        return funMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Fun record) {
        return funMapper.updateByPrimaryKey(record);
    }

    public List<Fun> findAllByFkUIdAndFPassword(Integer fkUId,
                                                String fPassword){
        return funMapper.findAllByFkUIdAndFPassword(fkUId, fPassword);
    }

    public List<Fun> findAllByFkUIdAndFPasswordAndFNumber(Integer fkUId,
                                                          String fPassword,
                                                          Integer fNumber){
        return funMapper.findAllByFkUIdAndFPasswordAndFNumber(fkUId, fPassword, fNumber);
    }

    public int updateByFkUIdAndFPasswordAndFNumber(Fun updated,
                                                   Integer fkUId,
                                                   String fPassword){
        return funMapper.updateByFkUIdAndFPasswordAndFNumber(updated, fkUId, fPassword);
    }

}
