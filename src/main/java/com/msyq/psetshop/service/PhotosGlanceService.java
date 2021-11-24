package com.msyq.psetshop.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.msyq.psetshop.pojo.PhotosGlance;
import com.msyq.psetshop.mapper.PhotosGlanceMapper;

import java.util.List;

@Service
public class PhotosGlanceService{

    @Resource
    private PhotosGlanceMapper photosGlanceMapper;

    
    public int deleteByPrimaryKey(Integer pgId) {
        return photosGlanceMapper.deleteByPrimaryKey(pgId);
    }

    
    public int insert(PhotosGlance record) {
        return photosGlanceMapper.insert(record);
    }

    
    public int insertSelective(PhotosGlance record) {
        return photosGlanceMapper.insertSelective(record);
    }

    
    public PhotosGlance selectByPrimaryKey(Integer pgId) {
        return photosGlanceMapper.selectByPrimaryKey(pgId);
    }

    
    public int updateByPrimaryKeySelective(PhotosGlance record) {
        return photosGlanceMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(PhotosGlance record) {
        return photosGlanceMapper.updateByPrimaryKey(record);
    }


    public  Integer countByFkPId(Integer fkPId){
        return photosGlanceMapper.countByFkPId(fkPId);
    }

    public int countByFkUId(Integer fkUId){
        return photosGlanceMapper.countByFkUId(fkUId);
    }

    public int countByPgTf(Integer integer){
        return photosGlanceMapper.countByFkUId(integer);
    }

    public List<PhotosGlance> findAllByFkUIdAndFkPId(Integer fkUId, Integer fkPId){
        return photosGlanceMapper.findAllByFkUIdAndFkPId(fkUId, fkPId);
    }

    public Integer countByFkPIdAndPgTf(Integer fkPId,Integer pgTf){
        return photosGlanceMapper.countByFkPIdAndPgTf(fkPId, pgTf);
    }

    public int updateByFkUIdAndFkPId(PhotosGlance updated){
        return photosGlanceMapper.updateByFkUIdAndFkPId(updated, updated.getFkUId(), updated.getFkPId());
    }

}
