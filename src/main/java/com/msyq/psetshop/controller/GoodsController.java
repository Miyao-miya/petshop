package com.msyq.psetshop.controller;

import com.github.pagehelper.PageInfo;
import com.msyq.psetshop.PoToVo.GoodsToVO;
import com.msyq.psetshop.pojo.Goods;
import com.msyq.psetshop.pojo.GoodsCategory;
import com.msyq.psetshop.service.GoodsCategoryService;
import com.msyq.psetshop.service.GoodsService;
import com.msyq.psetshop.utils.aop.logAnnotation.LogAnnotation;
import com.msyq.psetshop.vo.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{fkId}/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GoodsCategoryService goodsCategoryService;


    //      添加商品
    @PostMapping("/insert")
    @LogAnnotation(module = "商品", operator = "添加商品")
    public int goodsinsert(@PathVariable("fkId") Integer fkId,
                           @RequestBody Goods goods) {
        return goodsService.insertSelective(goods);
    }

    //      删除商品
    @GetMapping("/delect/{i}")
    @LogAnnotation(module = "商品", operator = "删除商品")
    public int goodsdelete(@PathVariable("fkId") Integer fkId,
                           @PathVariable("i") Integer integer) {
        return goodsService.deleteByPrimaryKey(integer);
    }

    //    修改商品信息
    @PostMapping("/updata")
    @LogAnnotation(module = "商品", operator = "修改商品")
    public int goodsUpdata(@PathVariable("fkId") Integer fkId,
                           @RequestBody Goods goods) {
        return goodsService.updateByPrimaryKeySelective(goods);
    }

    //    根基Id查找商品
    @GetMapping("/select/{i}")
    public GoodsVO selectByPrimaryKey(@PathVariable("i") Integer gId) {
        return GoodsToVO.goodsToVO.goodsVO(goodsService.selectByPrimaryKey(gId));
    }

    //    根据商品名查询商品
    @GetMapping("/select/gname/{i}")
    public PageInfo<GoodsVO> findAllByGName(@PathVariable("i") String gName) {
        return GoodsToVO.goodsToVO.goodsPage(goodsService.findAllByGName(gName));
    }

    //    分页查看商品列表   宠物图片列表
    @GetMapping("/findall/{i}/{j}")
    public PageInfo<GoodsVO> goodsPageInfo(@PathVariable("i") Integer page,
                                           @PathVariable("j") Integer size) {
        return GoodsToVO.goodsToVO.goodsPage(goodsService.findAll(new Goods(), page, size));
    }


    //    根据商品分类查找
    @GetMapping("/findall/gc/{i}/{page}/{size}")
    public PageInfo<GoodsVO> goodsCategoryPageInfo(@PathVariable("i") String gc,
                                                   @PathVariable("page") Integer page,
                                                   @PathVariable("size") Integer size) {
        return GoodsToVO.goodsToVO.goodsPage(goodsService.findAllByFkGcId(gc, page, size));
    }

    //    根据商品type查找
    @GetMapping("/findall/type/{i}/{page}/{size}")
    public PageInfo<GoodsVO> findAllByFkTypeId(@PathVariable("i") String type,
                                               @PathVariable("page") Integer page,
                                               @PathVariable("size") Integer size) {
        return GoodsToVO.goodsToVO.goodsPage(goodsService.findAllByFkTypeId(type, page, size));
    }

}
