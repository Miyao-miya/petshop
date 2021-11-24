package com.msyq.psetshop.PoToVo.component;


import com.msyq.psetshop.PoToVo.BusinessToVO;
import com.msyq.psetshop.PoToVo.DoctorToVO;
import com.msyq.psetshop.PoToVo.UsersToVO;
import com.msyq.psetshop.pojo.Doctor;
import com.msyq.psetshop.service.BusinessService;
import com.msyq.psetshop.service.DoctorService;
import com.msyq.psetshop.service.UsersService;
import com.msyq.psetshop.utils.date.DateTimeUtils;
import com.msyq.psetshop.vo.BusinessVO;
import com.msyq.psetshop.vo.DoctorVO;
import com.msyq.psetshop.vo.UsersVO;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

@Component
public class MakeToVOQ {

    private static MakeToVOQ makeToVOQ;

    @Autowired
    private BusinessService businessService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private UsersService usersService;

    @PostConstruct
    public void init(){
        makeToVOQ = this;
        makeToVOQ.businessService = this.businessService;
        makeToVOQ.doctorService = this.doctorService;
        makeToVOQ.usersService = this.usersService;
    }

    @Named("fkBId")
    public BusinessVO fkBId(Integer integer){
        if (integer == null){
            return null;
        }
        return BusinessToVO.businessToVO.businessVO(makeToVOQ.businessService.selectByPrimaryKey(integer));
    }

    @Named("fkUId")
    public UsersVO fkUId(Integer integer){
        if (integer == null){
            return null;
        }
        return UsersToVO.usersToVO.usersVO(makeToVOQ.usersService.selectByPrimaryKey(integer));
    }

    @Named("fkDId")
    public DoctorVO fkDId(Integer integer){
        if (integer == null){
            return null;
        }
        return DoctorToVO.doctorToVO.doctorVO(makeToVOQ.doctorService.selectByPrimaryKey(integer));
    }

    @Named("dateToStr")
    public String dateToStr(Date date){
        if (date == null){
            return "";
        }
        return DateTimeUtils.DATE.formatDate(date);
    }

}
