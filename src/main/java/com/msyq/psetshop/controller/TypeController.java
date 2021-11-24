package com.msyq.psetshop.controller;


import com.msyq.psetshop.pojo.Type;
import com.msyq.psetshop.service.TypeService;
import com.msyq.psetshop.utils.aop.logAnnotation.LogAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{fkId}/type")
public class TypeController {

    @Autowired
    private TypeService typeService;

//    添加标签
    @PostMapping("/insert")
    @LogAnnotation(module = "标签", operator = "添加标签")
    public int insert(@PathVariable("fkId") Integer fkId,
                      @RequestBody Type type){
        return typeService.insertSelective(type);
    }

//   输出标签列表
    @GetMapping("/listByAll")
    public List<Type> listByAll(){
        return typeService.listByAll();
    }

}
