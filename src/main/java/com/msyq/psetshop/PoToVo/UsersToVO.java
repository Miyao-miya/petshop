package com.msyq.psetshop.PoToVo;

import com.github.pagehelper.PageInfo;
import com.msyq.psetshop.pojo.Doctor;
import com.msyq.psetshop.pojo.Users;
import com.msyq.psetshop.utils.date.DateTimeUtils;
import com.msyq.psetshop.vo.DoctorVO;
import com.msyq.psetshop.vo.UsersVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;


import java.util.Date;
import java.util.List;

@Mapper
public interface UsersToVO {


    UsersToVO usersToVO = Mappers.getMapper(UsersToVO.class);

    @Named("dateToStr")
    default String dateToStr(Date date){
        if (date == null){
            return null;
        }
        return DateTimeUtils.DATE.formatDate(date);
    }

    @Named("uPassword")
    default String uPassword(String str){
        return null;
    }

//    users
    @Mappings(
            {
                    @Mapping(source = "UDate", target = "udate",qualifiedByName = "dateToStr"),
                    @Mapping(source = "UPassword", target = "UPassword", qualifiedByName = "uPassword")
            }
    )
    UsersVO usersVO(Users users);

    List<UsersVO> usersVo(List<Users> users);

    PageInfo<UsersVO> usersPage(PageInfo<Users> usersPageInfo);

//    dockerVO
    @Mappings({
            @Mapping(source = "DDate", target = "DDate",qualifiedByName = "dateToStr")
    })
    DoctorVO doctorVO(Doctor doctor);

    List<DoctorVO> listDoctorVO(List<Doctor> doctorList);

    PageInfo<DoctorVO> pageInfoVO(PageInfo<Doctor> doctorPageInfo);

}
