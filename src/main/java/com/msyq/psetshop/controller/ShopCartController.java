package com.msyq.psetshop.controller;

import com.github.pagehelper.PageInfo;
import com.msyq.psetshop.PoToVo.ShopCartToVO;
import com.msyq.psetshop.PoToVo.component.ShopCartToVOQ;
import com.msyq.psetshop.pojo.ShopCart;
import com.msyq.psetshop.service.GoodsService;
import com.msyq.psetshop.service.ShopCartService;
import com.msyq.psetshop.utils.aop.logAnnotation.LogAnnotation;
import com.msyq.psetshop.vo.ShopCartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{fkId}/shopcart")
public class ShopCartController {

    @Autowired
    private ShopCartService shopCartService;

    @Autowired
    private GoodsService goodsService;

    //    加入购物车
    @PostMapping("/insert")
    @LogAnnotation(module = "购物车", operator = "添加购物车")
    public int insert(@PathVariable("fkId") Integer fkId,
                      @RequestBody ShopCart shopCart) {
        return shopCartService.insertSelective(shopCart);
    }

    //    移出购物车
    @GetMapping("/delect/{i}")
    @LogAnnotation(module = "购物车", operator = "移出购物车")
    public int delect(@PathVariable("fkId") Integer fkId,
                      @PathVariable("i") Integer integer) {
        return shopCartService.deleteByPrimaryKey(integer);
    }

    //    根据ID查看购物车
    @GetMapping("/select/{i}")
    @LogAnnotation(module = "购物车", operator = "移出购物车")
    public ShopCartVO select(@PathVariable("fkId") Integer fkId,
                             @PathVariable("i") Integer integer) {
        return ShopCartToVO.shopCartToVO.shopCartVO(shopCartService.selectByPrimaryKey(integer));
    }

    //    查看购物车列表
    @GetMapping("/findall/{i}/{j}")
    public PageInfo<ShopCartVO> shopCartPage(@PathVariable("i") Integer page, @PathVariable("j") Integer size) {
        return ShopCartToVO.shopCartToVO.shopCartPage(shopCartService.listByAll(page, size));
    }

    //    根据用户Id 查找购物车
    @GetMapping("/findAllByFkUId/{uid}/{i}/{j}")
    public PageInfo<ShopCartVO> findAllByFkUId(@PathVariable("uid") Integer fkUId,
                                               @PathVariable("i") Integer page,
                                               @PathVariable("j") Integer size) {

        return ShopCartToVO.shopCartToVO.shopCartPage(shopCartService.findAllByFkUId(fkUId, page, size));

    }

}
