package com.msyq.psetshop.PoToVo.component;

import com.msyq.psetshop.PoToVo.UsersToVO;
import com.msyq.psetshop.service.UsersService;
import com.msyq.psetshop.vo.UsersVO;
import org.aspectj.lang.annotation.Pointcut;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class GradeToVOQ {

    public static GradeToVOQ gradeToVOQ;

    @Autowired
    private UsersService usersService;

    @PostConstruct
    public void init(){
        gradeToVOQ = this;
        gradeToVOQ.usersService = this.usersService;
    }

    @Named("fkId")
    public UsersVO fkId(Integer integer){
        if (integer != null){
            return UsersToVO.usersToVO.usersVO(gradeToVOQ.usersService.selectByPrimaryKey(integer));
        }return null;
    }

}
