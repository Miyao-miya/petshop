package com.msyq.psetshop.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Date;

import com.msyq.psetshop.pojo.Post;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostMapper {
    int deleteByPrimaryKey(Integer pId);

    int insert(Post record);

    int insertSelective(Post record);

    Post selectByPrimaryKey(Integer pId);

    int updateByPrimaryKeySelective(Post record);

    int updateByPrimaryKey(Post record);

    List<Post> findByAll(Post post);

    List<Post> listByAll();

    List<Post> findAllByFkUId(@Param("fkUId") Integer fkUId);

    List<Post> findAllByFkUIdOrderLike(@Param("fkUId") Integer fkUId);

    List<Post> findAllByFkUIdOrderCollect(@Param("fkUId") Integer fkUId);

    List<Post> findByAllOrderLike();
}