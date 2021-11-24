package com.msyq.psetshop.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.msyq.psetshop.mapper.PostAnswerMapper;
import com.msyq.psetshop.pojo.PostAnswer;

@Service
public class PostAnswerService {

    @Resource
    private PostAnswerMapper postAnswerMapper;


    public int deleteByPrimaryKey(Integer paId) {
        return postAnswerMapper.deleteByPrimaryKey(paId);
    }


    public int insert(PostAnswer record) {
        return postAnswerMapper.insert(record);
    }


    public int insertSelective(PostAnswer record) {
        return postAnswerMapper.insertSelective(record);
    }


    public PostAnswer selectByPrimaryKey(Integer paId) {
        return postAnswerMapper.selectByPrimaryKey(paId);
    }


    public int updateByPrimaryKeySelective(PostAnswer record) {
        return postAnswerMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(PostAnswer record) {
        return postAnswerMapper.updateByPrimaryKey(record);
    }


    public PageInfo<PostAnswer> findByAllPidPasid(PostAnswer postAnswer,
                                                  Integer page,
                                                  Integer size) {
        PageHelper.startPage(page, size);
        return new PageInfo<>(postAnswerMapper.findByAll(postAnswer));
    }

    public PageInfo<PostAnswer> findByAll(Integer fkPId,
                                          Integer page,
                                          Integer size) {
        PageHelper.startPage(page, size);
        return new PageInfo<>(postAnswerMapper.listByAll(fkPId));
    }

    public Integer countByFkPId(Integer fkPId){
        return postAnswerMapper.countByFkPId(fkPId);
    }

}


