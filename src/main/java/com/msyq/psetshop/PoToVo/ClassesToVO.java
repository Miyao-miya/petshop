package com.msyq.psetshop.PoToVo;

import com.github.pagehelper.PageInfo;
import com.msyq.psetshop.pojo.Classes;
import com.msyq.psetshop.utils.date.DateTimeUtils;
import com.msyq.psetshop.vo.ClassesVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Date;
import java.util.List;

@Mapper
public interface ClassesToVO {

    ClassesToVO classesToVO = Mappers.getMapper(ClassesToVO.class);

    @Named("dateToStr")
    default String dateToStr(Date date){
        if (date == null){
            return null;
        }
        return DateTimeUtils.TIME.formatDate(date);
    }

    @Mappings({
            @Mapping(source = "CDatea", target = "CDatea", qualifiedByName = "dateToStr"),
            @Mapping(source = "CDateb", target = "CDateb", qualifiedByName = "dateToStr"),
    })
    ClassesVO classesVO(Classes classes);

    List<ClassesVO> classesVOList(List<Classes> classesList);

    PageInfo<ClassesVO> classesVOPage(PageInfo<Classes> pageInfo);
}
