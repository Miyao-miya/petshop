package com.msyq.psetshop.PoToVo.component;

import com.msyq.psetshop.PoToVo.GoodsToVO;
import com.msyq.psetshop.PoToVo.UsersToVO;
import com.msyq.psetshop.service.GoodsService;
import com.msyq.psetshop.service.UsersService;
import com.msyq.psetshop.vo.GoodsVO;
import com.msyq.psetshop.vo.UsersVO;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ShopCartToVOQ {

    public static ShopCartToVOQ shopCartToVOQ;

    @Autowired
    UsersService usersService;

    @Autowired
    GoodsService goodsService;

    @PostConstruct
    public void init(){
        shopCartToVOQ = this;
        shopCartToVOQ.usersService = this.usersService;
        shopCartToVOQ.goodsService = this.goodsService;
    }


    @Named("fkUId")
    public UsersVO fkUId(Integer integer){
        if (integer == null){
            return null;
        }
        return UsersToVO.usersToVO.usersVO(shopCartToVOQ.usersService.selectByPrimaryKey(integer));
    }

    @Named("fkGId")
    public GoodsVO fkGId(Integer integer){
        if (integer == null){
            return null;
        }
        return GoodsToVO.goodsToVO.goodsVO(shopCartToVOQ.goodsService.selectByPrimaryKey(integer));
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
}
