package com.msyq.psetshop.controller;

import com.github.pagehelper.PageInfo;
import com.msyq.psetshop.PoToVo.AdimLogToVO;
import com.msyq.psetshop.pojo.AdimLog;
import com.msyq.psetshop.service.AdimLogService;
import com.msyq.psetshop.utils.aop.logAnnotation.LogAnnotation;
import com.msyq.psetshop.vo.AdimLogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/{fkId}/AdimLog")
public class AdimLogController {

    @Autowired
    private AdimLogService adimLogService;


    //    查询管理员日志
    @GetMapping("/findall/{i}/{j}")
    @LogAnnotation(module = "管理员日志", operator = "查询")
    public PageInfo<AdimLogVO> listByAll(@PathVariable("fkId") Integer fkId,
                                         @PathVariable("i") Integer page,
                                         @PathVariable("j") Integer size) {
        return AdimLogToVO.adimLogToVO.adimLogVOPage(adimLogService.listByAll(page, size));
    }


}
