package com.msyq.psetshop.PoToVo;

import com.github.pagehelper.PageInfo;
import com.msyq.psetshop.PoToVo.component.GradeToVOQ;
import com.msyq.psetshop.pojo.Grade;
import com.msyq.psetshop.vo.GradeVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = GradeToVOQ.class)
public interface GradeToVO {

    GradeToVO gradeToVO = Mappers.getMapper(GradeToVO.class);

    @Mappings({
            @Mapping(source = "fkId", target = "fkId", qualifiedByName = "fkId"),
    })
    GradeVO gradeVO(Grade grade);

    List<GradeVO> gradeVOList(List<Grade> grades);

    PageInfo<GradeVO> gradeVOPage(PageInfo<Grade> gradePageInfo);
}
