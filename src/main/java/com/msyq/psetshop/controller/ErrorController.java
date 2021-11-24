package com.msyq.psetshop.controller;


import com.github.pagehelper.PageInfo;
import com.msyq.psetshop.PoToVo.ErrorToVO;
import com.msyq.psetshop.service.ErrorService;
import com.msyq.psetshop.utils.aop.logAnnotation.LogAnnotation;
import com.msyq.psetshop.vo.ErrorVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/{fkId}/Error")
public class ErrorController {

    @Autowired
    private ErrorService errorService;



    //    删除日志
    @GetMapping("/delect/{i}")
    @LogAnnotation(module = "错误日志", operator = "查询")
    public int delect(@PathVariable("fkId") Integer fkId,
                       @PathVariable("i") Integer integer) {
        return errorService.deleteByPrimaryKey(integer);
    }

    //    查询错误日志
    @GetMapping("/listByAll/{i}/{j}")
    @LogAnnotation(module = "错误日志", operator = "查询")
    public PageInfo<ErrorVO> listByAll(@PathVariable("fkId") Integer fkId,
                                        @PathVariable("i") Integer page,
                                        @PathVariable("j") Integer size) {

        return ErrorToVO.errorToVO.errorVOPage(errorService.listByAll(page, size));
    }

}
