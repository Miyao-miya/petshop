package com.msyq.psetshop.PoToVo;

import com.github.pagehelper.PageInfo;
import com.msyq.psetshop.PoToVo.component.PostToVOQ;
import com.msyq.psetshop.pojo.Post;
import com.msyq.psetshop.vo.PostVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = PostToVOQ.class)
public interface PostToVO {

    PostToVO postToVO = Mappers.getMapper(PostToVO.class);

    @Mappings({
            @Mapping(source = "fkUId", target = "fkUId", qualifiedByName = "fkUId"),
            @Mapping(source = "fkTypeId", target = "fkTypeId", qualifiedByName = "fkTypeId"),
            @Mapping(source = "fkTId", target = "fkTId", qualifiedByName = "fkTId"),
            @Mapping(source = "PIssueDate", target = "PIssueDate", qualifiedByName = "dateToStr"),
            @Mapping(source = "PDate", target = "PDate", qualifiedByName = "dateToStr"),
    })
    PostVO postVO(Post post);

    List<PostVO> postVOList(List<Post> postList);

    PageInfo<PostVO> postVOPage(PageInfo<Post> postPageInfo);

}
