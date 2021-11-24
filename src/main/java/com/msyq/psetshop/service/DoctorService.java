package com.msyq.psetshop.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.msyq.psetshop.pojo.Doctor;
import com.msyq.psetshop.mapper.DoctorMapper;

import java.util.List;

@Service
public class DoctorService{

    @Resource
    private DoctorMapper doctorMapper;

    
    public int deleteByPrimaryKey(Integer dId) {
        return doctorMapper.deleteByPrimaryKey(dId);
    }

    
    public int insert(Doctor record) {
        return doctorMapper.insert(record);
    }

    
    public int insertSelective(Doctor record) {
        return doctorMapper.insertSelective(record);
    }

    
    public Doctor selectByPrimaryKey(Integer dId) {
        return doctorMapper.selectByPrimaryKey(dId);
    }

    
    public int updateByPrimaryKeySelective(Doctor record) {
        return doctorMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Doctor record) {
        return doctorMapper.updateByPrimaryKey(record);
    }

    public PageInfo<Doctor> findAll(Doctor doctor, Integer page, Integer size){
        PageHelper.startPage(page,size);
        return new PageInfo<Doctor>(doctorMapper.findByAll(doctor));
    }

}
