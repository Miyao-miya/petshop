package com.msyq.psetshop.mapper;

import com.msyq.psetshop.pojo.PostAnswer;
import org.apache.ibatis.annotations.Mapper;import org.apache.ibatis.annotations.Param;import java.util.List;

@Mapper
public interface PostAnswerMapper {
    int deleteByPrimaryKey(Integer paId);

    int insert(PostAnswer record);

    int insertSelective(PostAnswer record);

    PostAnswer selectByPrimaryKey(Integer paId);

    int updateByPrimaryKeySelective(PostAnswer record);

    int updateByPrimaryKey(PostAnswer record);

    List<PostAnswer> findByAll(PostAnswer postAnswer);

    List<PostAnswer> listByAll(@Param("fkPIdB") Integer fkPIdB);

    Integer countByFkPId(@Param("fkPId")Integer fkPId);


}