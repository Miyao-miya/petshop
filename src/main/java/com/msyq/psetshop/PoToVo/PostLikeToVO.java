package com.msyq.psetshop.PoToVo;

import com.github.pagehelper.PageInfo;
import com.msyq.psetshop.PoToVo.component.PostLikeToVOQ;
import com.msyq.psetshop.pojo.PostLike;
import com.msyq.psetshop.vo.PostLikeVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = PostLikeToVOQ.class)
public interface PostLikeToVO {

    PostLikeToVO postLikeToVO = Mappers.getMapper(PostLikeToVO.class);

    @Mappings({
            @Mapping(source = "fkPId", target = "fkPId", qualifiedByName = "fkPId"),
            @Mapping(source = "fkUId", target = "fkUId", qualifiedByName = "fkUId"),
            @Mapping(source = "plClickDate", target = "plClickDate", qualifiedByName = "dateToStr"),
            @Mapping(source = "plDate", target = "plDate", qualifiedByName = "dateToStr"),
    })
    PostLikeVO postLikeVO(PostLike postLike);

    List<PostLikeVO> postLikeVOList(List<PostLike> postLikes);

    PageInfo<PostLikeVO> postLikeVOPage(PageInfo<PostLike> postLikePageInfo);

}
