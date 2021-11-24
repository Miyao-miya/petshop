package com.msyq.psetshop.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.msyq.psetshop.pojo.PostLike;
import com.msyq.psetshop.mapper.PostLikeMapper;

import java.util.List;

@Service
public class PostLikeService{

    @Resource
    private PostLikeMapper postLikeMapper;

    
    public int deleteByPrimaryKey(Integer plId) {
        return postLikeMapper.deleteByPrimaryKey(plId);
    }

    
    public int insert(PostLike record) {
        return postLikeMapper.insert(record);
    }

    
    public int insertSelective(PostLike record) {
        return postLikeMapper.insertSelective(record);
    }

    
    public PostLike selectByPrimaryKey(Integer plId) {
        return postLikeMapper.selectByPrimaryKey(plId);
    }

    
    public int updateByPrimaryKeySelective(PostLike record) {
        return postLikeMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(PostLike record) {
        return postLikeMapper.updateByPrimaryKey(record);
    }

    public PageInfo<PostLike> listByAll(Integer page, Integer size){
        PageHelper.startPage(page,size);
        return new PageInfo<>(postLikeMapper.listByAll());
    }

    public List<PostLike> selectAllByFkPId(Integer fkPId){
        return postLikeMapper.selectAllByFkPId(fkPId);
    }

    public int deleteByFkPId(Integer fkPId){
        return postLikeMapper.deleteByFkPId(fkPId);
    }

    public Integer countByFkPId(Integer fkPId){
        return postLikeMapper.countByFkPId(fkPId);
    }

    public PageInfo<PostLike> findAllByFkUIdOrderByFkPId(Integer fkUId,
                                                     Integer page,
                                                     Integer size){
        PageHelper.startPage(page,size);
        return new PageInfo<>(postLikeMapper.findAllByFkUIdOrderByFkPId(fkUId));
    }

    public Integer countByFkPIdOrderByFkUId(Integer fkPId){
        return postLikeMapper.countByFkPIdOrderByFkUId(fkPId);
    }

    public Integer countByFkPIdOrderByFkUIdLike(Integer fkPId){
        return postLikeMapper.countByFkPIdOrderByFkUIdLike(fkPId);
    }

}
