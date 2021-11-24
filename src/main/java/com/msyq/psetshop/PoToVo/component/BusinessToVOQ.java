package com.msyq.psetshop.PoToVo.component;

import com.msyq.psetshop.pojo.BusinessCategory;
import com.msyq.psetshop.service.BusinessCategoryService;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class BusinessToVOQ {

    public static BusinessToVOQ businessToVOQ;

    @Autowired
    private BusinessCategoryService businessCategoryService;

    @PostConstruct
    public void init(){
        businessToVOQ = this;
        businessToVOQ.businessCategoryService = this.businessCategoryService;
    }


    @Named("fkBcId")
    public BusinessCategory fkBcId(Integer integer){
        if (integer == null){
            return null;
        }
        return businessToVOQ.businessCategoryService.selectByPrimaryKey(integer);
    }
}
