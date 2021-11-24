package com.msyq.psetshop.controller;


import com.msyq.psetshop.pojo.GoodsCategory;
import com.msyq.psetshop.service.GoodsCategoryService;
import com.msyq.psetshop.utils.aop.logAnnotation.LogAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{fkId}/GoodsCategory")
public class GoodsCategoryController {

    @Autowired
    private GoodsCategoryService goodsCategoryService;

    //    添加主题
    @PostMapping("/insert")
    @LogAnnotation(module = "主题", operator = "添加主题")
    public int insert(@PathVariable("fkId") Integer fkId,
                      @RequestBody GoodsCategory goodsCategory) {
        return goodsCategoryService.insertSelective(goodsCategory);
    }

    //    修改主题
    @PostMapping("/updata")
    @LogAnnotation(module = "主题", operator = "修改")
    public int updata(@PathVariable("fkId") Integer fkId,
                      @RequestBody GoodsCategory goodsCategory) {
        return goodsCategoryService.updateByPrimaryKeySelective(goodsCategory);
    }

    //    删除主题
    @GetMapping("/delect/{i}")
    @LogAnnotation(module = "主题", operator = "删除")
    public int delect(@PathVariable("fkId") Integer fkId,
                      @PathVariable("i") Integer integer) {
        return goodsCategoryService.deleteByPrimaryKey(integer);
    }

    //    查询主题
    @GetMapping("/listByAll")
    public List<GoodsCategory> listByAll() {
        return goodsCategoryService.listByAll();
    }
}
