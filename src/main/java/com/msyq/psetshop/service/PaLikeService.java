package com.msyq.psetshop.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.msyq.psetshop.pojo.PaLike;
import com.msyq.psetshop.mapper.PaLikeMapper;

import java.util.List;

@Service
public class PaLikeService{

    @Resource
    private PaLikeMapper paLikeMapper;

    
    public int deleteByPrimaryKey(Integer palId) {
        return paLikeMapper.deleteByPrimaryKey(palId);
    }

    
    public int insert(PaLike record) {
        return paLikeMapper.insert(record);
    }

    
    public int insertSelective(PaLike record) {
        return paLikeMapper.insertSelective(record);
    }

    
    public PaLike selectByPrimaryKey(Integer palId) {
        return paLikeMapper.selectByPrimaryKey(palId);
    }

    
    public int updateByPrimaryKeySelective(PaLike record) {
        return paLikeMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(PaLike record) {
        return paLikeMapper.updateByPrimaryKey(record);
    }


    public List<PaLike> selectAllByFkPaId(Integer fkPaId){
        return paLikeMapper.selectAllByFkPaId(fkPaId);
    }
}
