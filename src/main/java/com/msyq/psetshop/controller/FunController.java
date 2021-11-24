package com.msyq.psetshop.controller;

import com.msyq.psetshop.service.FunService;
import com.msyq.psetshop.utils.aop.logAnnotation.LogAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{fkId}/fun")
public class FunController {

    @Autowired
    private FunService funService;

    //    账号验证
    @GetMapping("/findAllByFkUIdAndFPassword/{fkuid}/{password}")
    @LogAnnotation(module = "账号管理", operator = "账号验证")
    public int findAllByFkUIdAndFPassword(@PathVariable("fkId") Integer fkId,
                                          @PathVariable("fkuid") Integer fkUId,
                                          @PathVariable("password") String password) {
        if (funService.findAllByFkUIdAndFPassword(fkUId, password).size() > 0) {
            return 1;
        } else return 0;
    }

//    资金验证

}
