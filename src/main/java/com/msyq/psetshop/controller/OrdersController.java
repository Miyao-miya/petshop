package com.msyq.psetshop.controller;

import com.github.pagehelper.PageInfo;
import com.msyq.psetshop.PoToVo.OrdersToVO;
import com.msyq.psetshop.pojo.Fun;
import com.msyq.psetshop.pojo.Orders;
import com.msyq.psetshop.service.FunService;
import com.msyq.psetshop.service.OrdersService;
import com.msyq.psetshop.utils.aop.logAnnotation.LogAnnotation;
import com.msyq.psetshop.vo.OrdersVO;
import com.msyq.psetshop.vo.ShopOrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{fkId}/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private FunService funService;

    //    添加订单
    @PostMapping("/insert")
    @LogAnnotation(module = "订单", operator = "添加订单")
    public int isert(@PathVariable("fkId") Integer fkId,
                     @RequestBody Orders orders) {
        return ordersService.insertSelective(orders);
    }

    //    根据ID查看订单
    @GetMapping("/select/{i}")
    public OrdersVO select(@PathVariable("fkId") Integer fkId,
                           @PathVariable("i") Integer integer) {
        return OrdersToVO.ordersToVO.ordersVO(ordersService.selectByPrimaryKey(integer));
    }

    //    修改订单信息
    @PostMapping("/updata")
    @LogAnnotation(module = "订单", operator = "修改订单")
    public int updata(@PathVariable("fkId") Integer fkId,
                      @RequestBody Orders orders) {
        return ordersService.updateByPrimaryKeySelective(orders);
    }

    //    删除订单新
    @GetMapping("/delect/{i}")
    @LogAnnotation(module = "订单", operator = "移出订单")
    public int delect(@PathVariable("fkId") Integer fkId,
                      @PathVariable("i") Integer integer) {
        return ordersService.deleteByPrimaryKey(integer);
    }

    //    查看订单列表
    @GetMapping("/findall/{i}/{j}")
    public PageInfo<OrdersVO> ordersPage(@PathVariable("i") Integer page,
                                         @PathVariable("j") Integer size) {
        return OrdersToVO.ordersToVO.oedersPage(ordersService.listByAll(page, size));
    }

    //    根据用户Id查询订单
    @GetMapping("/findAllUid/{uid}/{i}/{j}")
    public PageInfo<OrdersVO> findAllByFkUId(@PathVariable("uid") Integer fkUId,
                                             @PathVariable("i") Integer page,
                                             @PathVariable("j") Integer size) {
        return OrdersToVO.ordersToVO.oedersPage(ordersService.findAllByFkUId(fkUId, page, size));
    }

    //    根据用户Id查询订单
    @GetMapping("/findAllByFkUIdIng/{uid}/{i}/{j}")
    public PageInfo<OrdersVO> findAllByFkUIdIng(@PathVariable("uid") Integer fkUId,
                                                @PathVariable("i") Integer page,
                                                @PathVariable("j") Integer size) {
        return OrdersToVO.ordersToVO.oedersPage(ordersService.findAllByFkUIdIng(fkUId, page, size));
    }

    //    根据用户Id查询订单
    @GetMapping("/findAllByFkUIdEd/{uid}/{i}/{j}")
    public PageInfo<OrdersVO> findAllByFkUIdEd(@PathVariable("uid") Integer fkUId,
                                               @PathVariable("i") Integer page,
                                               @PathVariable("j") Integer size) {
        return OrdersToVO.ordersToVO.oedersPage(ordersService.findAllByFkUIdEd(fkUId, page, size));
    }


    //    购买商品
    @PostMapping("/shopOrderVo")
    public int shopOrder(@RequestBody ShopOrderVo shopOrderVo) {
//        验证资金书否充足
        if (funService.findAllByFkUIdAndFPasswordAndFNumber(shopOrderVo.getFkUId(),
                shopOrderVo.getPassword(),
                shopOrderVo.getOrders().getOPrice()).size() > 0) {
//            购买
//            生成直接订单
            ordersService.insertSelectiveCopy(shopOrderVo.getOrders());
//            账户同步
            Fun fun = new Fun();
            Integer integer = funService.findAllByFkUIdAndFPassword(shopOrderVo.getFkUId(), shopOrderVo.getPassword()).get(0).getFNumber();
            fun.setFNumber(integer - shopOrderVo.getOrders().getOPrice());
            if (funService.updateByFkUIdAndFPasswordAndFNumber(fun,shopOrderVo.getFkUId(),shopOrderVo.getPassword()) == 1){
                return 1;
            }
        }else {
            return -1;
        }

        return 0;
    }

}
