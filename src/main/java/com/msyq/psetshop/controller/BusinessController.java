package com.msyq.psetshop.controller;

import com.github.pagehelper.PageInfo;
import com.msyq.psetshop.PoToVo.BusinessToVO;
import com.msyq.psetshop.pojo.Business;
import com.msyq.psetshop.service.BusinessService;
import com.msyq.psetshop.utils.aop.logAnnotation.LogAnnotation;
import com.msyq.psetshop.vo.BusinessVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{fkId}/business")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    //    添加业务
    @PostMapping("/insert")
    @LogAnnotation(module = "业务", operator = "添加业务")
    public int insert(@PathVariable("fkId") Integer fkId,
            @RequestBody Business business) {
        return businessService.insertSelective(business);
    }

    //    修改业务
    @PostMapping("/updata")
    @LogAnnotation(module = "业务", operator = "修改业务")
    public int updata(@PathVariable("fkId") Integer fkId,
                      @RequestBody Business business) {
        return businessService.updateByPrimaryKeySelective(business);
    }

    //    删除业务
    @GetMapping("/delect/{i}")
    @LogAnnotation(module = "业务", operator = "删除业务")
    public int delect(@PathVariable("fkId") Integer fkId,
                      @PathVariable("i") Integer integer) {
        return businessService.deleteByPrimaryKey(integer);
    }


    //    默认列表查询业务
    @GetMapping("/findall/{i}/{j}")
    @LogAnnotation(module = "业务", operator = "分页查询业务")
    public PageInfo<BusinessVO> listByAll(@PathVariable("fkId") Integer fkId,
                                          @PathVariable("i") Integer page,
                                          @PathVariable("j") Integer size) {
        return BusinessToVO.businessToVO.businessVOPage(businessService.listByAll(page, size));
    }

}
