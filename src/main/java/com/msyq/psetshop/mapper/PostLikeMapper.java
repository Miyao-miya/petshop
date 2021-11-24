package com.msyq.psetshop.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Date;

import com.msyq.psetshop.pojo.PostLike;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostLikeMapper {
    int deleteByPrimaryKey(Integer plId);

    int insert(PostLike record);

    int insertSelective(PostLike record);

    PostLike selectByPrimaryKey(Integer plId);

    int updateByPrimaryKeySelective(PostLike record);

    int updateByPrimaryKey(PostLike record);

    List<PostLike> listByAll();

    List<PostLike> selectAllByFkPId(@Param("fkPId")Integer fkPId);

    int deleteByFkPId(@Param("fkPId")Integer fkPId);

    Integer countByFkPId(@Param("fkPId")Integer fkPId);

    List<PostLike> findAllByFkUIdOrderByFkPId(@Param("fkUId")Integer fkUId);

    Integer  countByFkPIdOrderByFkUId(@Param("fkPId")Integer fkPId);

    Integer  countByFkPIdOrderByFkUIdLike(@Param("fkPId")Integer fkPId);

}