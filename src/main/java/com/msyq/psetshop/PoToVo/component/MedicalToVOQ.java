package com.msyq.psetshop.PoToVo.component;

import com.msyq.psetshop.PoToVo.BusinessToVO;
import com.msyq.psetshop.PoToVo.DoctorToVO;
import com.msyq.psetshop.PoToVo.UsersToVO;
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
public class MedicalToVOQ {

    public static MedicalToVOQ medicalToVOQ;

    @Autowired
    private BusinessService businessService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private DoctorService doctorService;

    @PostConstruct
    public void init(){
        medicalToVOQ = this;
        medicalToVOQ.businessService = this.businessService;
        medicalToVOQ.usersService = this.usersService;
        medicalToVOQ.doctorService = this.doctorService;
    }

    @Named("fkBId")
    public BusinessVO fkBId(Integer integer){
        if (integer == null){
            return null;
        }else return BusinessToVO.businessToVO.businessVO(medicalToVOQ.businessService.selectByPrimaryKey(integer));
    }

    @Named("fkUId")
    public UsersVO fkUId(Integer integer){
        if (integer == null){
            return  null;
        }else return UsersToVO.usersToVO.usersVO(medicalToVOQ.usersService.selectByPrimaryKey(integer));
    }

    @Named("fkDId")
    public DoctorVO fkDId(Integer integer){
        if (integer == null){
            return  null;
        }else return DoctorToVO.doctorToVO.doctorVO(medicalToVOQ.doctorService.selectByPrimaryKey(integer));
    }

    @Named("dateToStr")
    public String dateToStr(Date date){
        if (date == null){
            return null;
        }
        return DateTimeUtils.DATE.formatDate(date);
    }

}
