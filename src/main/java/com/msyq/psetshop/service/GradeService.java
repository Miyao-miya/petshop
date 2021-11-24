package com.msyq.psetshop.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.msyq.psetshop.pojo.Grade;
import com.msyq.psetshop.mapper.GradeMapper;

import java.util.List;

@Service
public class GradeService{

    @Resource
    private GradeMapper gradeMapper;

    
    public int deleteByPrimaryKey(Integer gId) {
        return gradeMapper.deleteByPrimaryKey(gId);
    }

    
    public int insert(Grade record) {
        return gradeMapper.insert(record);
    }

    
    public int insertSelective(Grade record) {
        return gradeMapper.insertSelective(record);
    }

    
    public Grade selectByPrimaryKey(Integer gId) {
        return gradeMapper.selectByPrimaryKey(gId);
    }

    
    public int updateByPrimaryKeySelective(Grade record) {
        return gradeMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Grade record) {
        return gradeMapper.updateByPrimaryKey(record);
    }


    public List<Grade> findAllByFkId(Integer fkId){
        return gradeMapper.findAllByFkId(fkId);
    }
}
