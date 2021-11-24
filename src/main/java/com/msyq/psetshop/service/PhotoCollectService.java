package com.msyq.psetshop.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.msyq.psetshop.mapper.PhotoCollectMapper;
import com.msyq.psetshop.pojo.PhotoCollect;

import java.util.List;

@Service
public class PhotoCollectService{

    @Resource
    private PhotoCollectMapper photoCollectMapper;

    
    public int deleteByPrimaryKey(Integer pcId) {
        return photoCollectMapper.deleteByPrimaryKey(pcId);
    }

    
    public int insert(PhotoCollect record) {
        return photoCollectMapper.insert(record);
    }

    
    public int insertSelective(PhotoCollect record) {
        return photoCollectMapper.insertSelective(record);
    }

    
    public PhotoCollect selectByPrimaryKey(Integer pcId) {
        return photoCollectMapper.selectByPrimaryKey(pcId);
    }

    
    public int updateByPrimaryKeySelective(PhotoCollect record) {
        return photoCollectMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(PhotoCollect record) {
        return photoCollectMapper.updateByPrimaryKey(record);
    }

    public PageInfo<PhotoCollect> listByAll(Integer page, Integer size){
        PageHelper.startPage(page,size);
        return new PageInfo<>(photoCollectMapper.listByAll());
    }

    public List<PhotoCollect> findAllByFkUIdAndFkPgId(Integer fkUId, Integer fkPgId){
        return photoCollectMapper.findAllByFkUIdAndFkPgId(fkUId, fkPgId);
    }

    public Integer countByFkPgId(Integer fkPgId){
        return photoCollectMapper.countByFkPgId(fkPgId);
    }

    public int updateByFkUIdAndFkPgId(PhotoCollect updated){
        return photoCollectMapper.updateByFkUIdAndFkPgId(updated, updated.getFkUId(), updated.getFkPgId());
    }

    public  int deleteByFkUIdAndFkPgId(Integer fkUId,Integer fkPgId){
        return photoCollectMapper.deleteByFkUIdAndFkPgId(fkUId, fkPgId);
    }
}
