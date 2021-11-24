package com.msyq.psetshop.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.msyq.psetshop.mapper.PhotosMapper;
import com.msyq.psetshop.pojo.Photos;

import java.util.List;

@Service
public class PhotosService{

    @Resource
    private PhotosMapper photosMapper;

    
    public int deleteByPrimaryKey(Integer pId) {
        return photosMapper.deleteByPrimaryKey(pId);
    }

    
    public int insert(Photos record) {
        return photosMapper.insert(record);
    }

    
    public int insertSelective(Photos record) {
        return photosMapper.insertSelective(record);
    }

    
    public Photos selectByPrimaryKey(Integer pId) {
        return photosMapper.selectByPrimaryKey(pId);
    }

    
    public int updateByPrimaryKeySelective(Photos record) {
        return photosMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Photos record) {
        return photosMapper.updateByPrimaryKey(record);
    }


    public PageInfo<Photos> findByAll(Photos photos,
                                      Integer page,
                                      Integer size){
        PageHelper.startPage(page,size);
        return new PageInfo<>(photosMapper.findByAll(photos));
    }

    public PageInfo<Photos> listByAll(Integer page,
                                      Integer size){
        PageHelper.startPage(page,size);
        return new PageInfo<>(photosMapper.listByAll());
    }

    public PageInfo<Photos> findAllByFkUId(Integer fkUId,
                                           Integer page,
                                           Integer size){
        PageHelper.startPage(page, size);
        return new PageInfo<>(photosMapper.findAllByFkUId(fkUId));
    }

    public PageInfo<Photos> findAllByFkUIdGroupCollect(Integer fkUId,
                                                       Integer page,
                                                       Integer size){
        PageHelper.startPage(page, size);
        return new PageInfo<>(photosMapper.findAllByFkUIdGroupCollect(fkUId));
    }

    public PageInfo<Photos> findAllByFkUIdGroupLike(Integer fkUId,
                                                    Integer page,
                                                    Integer size){
        PageHelper.startPage(page, size);
        return new PageInfo<>(photosMapper.findAllByFkUIdGroupLike(fkUId));
    }

}
