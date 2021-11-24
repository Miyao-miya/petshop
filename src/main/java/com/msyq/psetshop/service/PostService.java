package com.msyq.psetshop.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.msyq.psetshop.pojo.Post;
import com.msyq.psetshop.mapper.PostMapper;

import java.util.List;

@Service
public class PostService {

    @Resource
    private PostMapper postMapper;


    public int deleteByPrimaryKey(Integer pId) {
        return postMapper.deleteByPrimaryKey(pId);
    }


    public int insert(Post record) {
        return postMapper.insert(record);
    }


    public int insertSelective(Post record) {
        return postMapper.insertSelective(record);
    }


    public Post selectByPrimaryKey(Integer pId) {
        return postMapper.selectByPrimaryKey(pId);
    }


    public int updateByPrimaryKeySelective(Post record) {
        return postMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(Post record) {
        return postMapper.updateByPrimaryKey(record);
    }

    public PageInfo<Post> findByAll(Post post, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        return new PageInfo<>(postMapper.findByAll(post));
    }


    public PageInfo<Post> listByAll(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        return new PageInfo<>(postMapper.listByAll());
    }

    public PageInfo<Post> findAllByFkUId(Integer fkUId,
                                         Integer page,
                                         Integer size) {
        PageHelper.startPage(page, size);
        return new PageInfo<>(postMapper.findAllByFkUId(fkUId));
    }

    public PageInfo<Post> findAllByFkUIdOrderLike(Integer fkUId,
                                                  Integer page,
                                                  Integer size) {
        PageHelper.startPage(page, size);
        return new PageInfo<>(postMapper.findAllByFkUIdOrderLike(fkUId));
    }

    public PageInfo<Post> findAllByFkUIdOrderCollect(Integer fkUId,
                                                     Integer page,
                                                     Integer size) {
        PageHelper.startPage(page, size);
        return new PageInfo<>(postMapper.findAllByFkUIdOrderCollect(fkUId));
    }

    public PageInfo<Post> findByAllOrderLike(Integer page,
                                             Integer size) {
        PageHelper.startPage(page, size);
        return new PageInfo<>(postMapper.findByAllOrderLike());
    }

}
