package com.msyq.psetshop.PoToVo;

import com.github.pagehelper.PageInfo;
import com.msyq.psetshop.PoToVo.component.PostAnswerToVOQ;
import com.msyq.psetshop.pojo.PaLike;
import com.msyq.psetshop.pojo.PostAnswer;
import com.msyq.psetshop.vo.PostAnswerVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = PostAnswerToVOQ.class)
public interface PostAnswerToVO {

    PostAnswerToVO postAnswerToVO = Mappers.getMapper(PostAnswerToVO.class);

    @Mappings({
            @Mapping(source = "paId", target = "paId", qualifiedByName = "paId"),
            @Mapping(source = "fkPId", target = "fkPId", qualifiedByName = "fkPId"),
            @Mapping(source = "pasId", target = "pasId", qualifiedByName = "pasId"),
            @Mapping(source = "fkUId", target = "fkUId", qualifiedByName = "fkUId"),
            @Mapping(source = "paDate", target = "paDate", qualifiedByName = "dateToStr"),
    })
    PostAnswerVO postAnswerVO(PostAnswer postAnswer);

    List<PostAnswerVO> postAnswerVOList(List<PostAnswer> postAnswers);

    PageInfo<PostAnswerVO> postAnswerVOPage(PageInfo<PostAnswer> postAnswerPageInfo);

}
