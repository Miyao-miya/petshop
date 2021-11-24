package com.msyq.psetshop.PoToVo;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.msyq.psetshop.pojo.UserLog;
import com.msyq.psetshop.utils.date.DateTimeUtils;
import com.msyq.psetshop.vo.UserLogVO;
import com.msyq.psetshop.vo.UsersVO;
import org.apache.catalina.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Date;
import java.util.List;

@Mapper
public interface UserLogToVO {

    UserLogToVO usersToVO = Mappers.getMapper(UserLogToVO.class);

    @Mappings({
            @Mapping(source = "ulDate", target = "ulDate", qualifiedByName = "dateToStr")
    })
    UserLogVO userLogVO(UserLog userLog);

    List<UserLogVO> userLogVOList(List<UserLog> userLogs);

    PageInfo<UserLogVO> userLogVOPage(PageInfo<UserLog> userLogPageInfo);


    @Named("dateToStr")
    default String dateToStr(Date date){
        if (date == null){
            return null;
        }
        return DateTimeUtils.DATE_TIME_MILLI.formatDate(date);
    }
}
