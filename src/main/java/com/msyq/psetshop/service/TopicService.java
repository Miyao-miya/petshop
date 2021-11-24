package com.msyq.psetshop.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.msyq.psetshop.pojo.Topic;
import com.msyq.psetshop.mapper.TopicMapper;
@Service
public class TopicService{

    @Resource
    private TopicMapper topicMapper;

    
    public int deleteByPrimaryKey(Integer tId) {
        return topicMapper.deleteByPrimaryKey(tId);
    }

    
    public int insert(Topic record) {
        return topicMapper.insert(record);
    }

    
    public int insertSelective(Topic record) {
        return topicMapper.insertSelective(record);
    }

    
    public Topic selectByPrimaryKey(Integer tId) {
        return topicMapper.selectByPrimaryKey(tId);
    }

    
    public int updateByPrimaryKeySelective(Topic record) {
        return topicMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Topic record) {
        return topicMapper.updateByPrimaryKey(record);
    }

}
