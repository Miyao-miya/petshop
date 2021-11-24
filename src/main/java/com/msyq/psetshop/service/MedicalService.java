package com.msyq.psetshop.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.msyq.psetshop.pojo.Medical;
import com.msyq.psetshop.mapper.MedicalMapper;

import java.util.List;

@Service
public class MedicalService {

    @Resource
    private MedicalMapper medicalMapper;


    public int deleteByPrimaryKey(Integer mId) {
        return medicalMapper.deleteByPrimaryKey(mId);
    }


    public int insert(Medical record) {
        return medicalMapper.insert(record);
    }


    public int insertSelective(Medical record) {
        return medicalMapper.insertSelective(record);
    }


    public Medical selectByPrimaryKey(Integer mId) {
        return medicalMapper.selectByPrimaryKey(mId);
    }


    public int updateByPrimaryKeySelective(Medical record) {
        return medicalMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(Medical record) {
        return medicalMapper.updateByPrimaryKey(record);
    }

    public PageInfo<Medical> findAllByFkUId(Integer fkUId,
                                            Integer page,
                                            Integer size) {
        PageHelper.startPage(page, size);
        return new PageInfo<>(medicalMapper.findAllByFkUId(fkUId));
    }

    public PageInfo<Medical> findAllByFkDId(Integer fkDId,
                                            Integer page,
                                            Integer size) {
        PageHelper.startPage(page,size);
        return new PageInfo<>(medicalMapper.findAllByFkDId(fkDId));
    }

    public PageInfo<Medical> listByAll(Integer page, Integer size){
        PageHelper.startPage(page,size);
        return new PageInfo<>(medicalMapper.listByAll());
    }

    public  List<Medical> findAllByFkUIdAndFkDId(Integer fkUId,
                                                 Integer fkDId){
        return medicalMapper.findAllByFkUIdAndFkDId(fkUId, fkDId);
    }

}
