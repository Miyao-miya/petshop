package com.msyq.psetshop.PoToVo;

import com.github.pagehelper.PageInfo;
import com.msyq.psetshop.pojo.Error;
import com.msyq.psetshop.utils.date.DateTimeUtils;
import com.msyq.psetshop.vo.ErrorVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Date;
import java.util.List;

@Mapper
public interface ErrorToVO {

    ErrorToVO errorToVO = Mappers.getMapper(ErrorToVO.class);

    @Named("dateToStr")
    default String dateToStr(Date date){
        if (date == null){
            return null;
        }
        return DateTimeUtils.DATE_TIME_MILLI.formatDate(date);
    }

    @Mappings({
            @Mapping(source = "EDate", target = "EDate", qualifiedByName = "dateToStr")
    })
    ErrorVO errorVO(Error error);

    List<ErrorVO> errorVoList(List<Error> errorList);

    PageInfo<ErrorVO> errorVOPage(PageInfo<Error> errorPageInfo);
}
