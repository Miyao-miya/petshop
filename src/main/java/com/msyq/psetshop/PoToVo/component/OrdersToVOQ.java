package com.msyq.psetshop.PoToVo.component;

import com.msyq.psetshop.PoToVo.GoodsToVO;
import com.msyq.psetshop.PoToVo.UsersToVO;
import com.msyq.psetshop.service.GoodsService;
import com.msyq.psetshop.service.UsersService;
import com.msyq.psetshop.utils.date.DateTimeUtils;
import com.msyq.psetshop.vo.GoodsVO;
import com.msyq.psetshop.vo.UsersVO;
import org.aspectj.lang.annotation.Pointcut;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

@Component
public class OrdersToVOQ {

    public static OrdersToVOQ ordersToVOQ;

    @Autowired
    private UsersService usersService;

    @Autowired
    private GoodsService goodsService;

    @PostConstruct
    private void init(){
        ordersToVOQ = this;
        ordersToVOQ.usersService = this.usersService;
        ordersToVOQ.goodsService = this.goodsService;
    }

    @Named("fkGId")
    public GoodsVO fkGId(Integer integer){
        if (integer == null){
            return null;
        }
        return GoodsToVO.goodsToVO.goodsVO(ordersToVOQ.goodsService.selectByPrimaryKey(integer));
    }

    @Named("fkUId")
    public UsersVO fkUId(Integer integer){
        if (integer == null){
            return null;
        }
        return UsersToVO.usersToVO.usersVO(ordersToVOQ.usersService.selectByPrimaryKey(integer));
    }

    //    空处理
    @Named("strNoNull")
    public String strNoNull(String str){
        if (str == null){
            return null;
        }else return str;
    }

    @Named("intNoNull")
    public Integer intNoNull(Integer integer){
        if (integer == null){
            return null;
        }else return integer;
    }

    @Named("dateToStr")
    public String dateToStr(Date date){
        if (date == null){
            return null;
        }
        return DateTimeUtils.DATE_TIME.formatDate(date);
    }

}
