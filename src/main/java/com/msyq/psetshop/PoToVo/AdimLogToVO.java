package com.msyq.psetshop.PoToVo;

import com.github.pagehelper.PageInfo;
import com.msyq.psetshop.PoToVo.component.BusinessToVOQ;
import com.msyq.psetshop.pojo.AdimLog;
import com.msyq.psetshop.utils.date.DateTimeUtils;
import com.msyq.psetshop.vo.AdimLogVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Date;
import java.util.List;

@Mapper
public interface AdimLogToVO {

    @Named("dateToStr")
    default String dateToStr(Date date){
        if (date == null){
            return null;
        }
        return DateTimeUtils.DATE_TIME_MILLI.formatDate(date);
    }


    AdimLogToVO adimLogToVO = Mappers.getMapper(AdimLogToVO.class);

    @Mappings({
            @Mapping(source = "alDate", target = "alDate", qualifiedByName = "dateToStr"),
    })
    AdimLogVO  adimLogVO(AdimLog adimLog);

    List<AdimLogVO> adimLogVO(List<AdimLog> adimLogs);

    PageInfo<AdimLogVO> adimLogVOPage(PageInfo<AdimLog> adimLogPageInfo);

}
