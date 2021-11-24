package com.msyq.psetshop.controller;


import com.github.pagehelper.PageInfo;
import com.msyq.psetshop.PoToVo.ClassesToVO;
import com.msyq.psetshop.pojo.Classes;
import com.msyq.psetshop.service.ClassesService;
import com.msyq.psetshop.utils.aop.logAnnotation.LogAnnotation;
import com.msyq.psetshop.vo.ClassesVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{fkId}/Classes")
public class ClassesController {

    @Autowired
    private ClassesService classesService;

    //    添加排班
    @PostMapping("/insert")
    @LogAnnotation(module = "排班", operator = "添加排班")
    public int inset(@PathVariable("fkId") Integer fkId,
                     @RequestBody Classes classes) {
        return classesService.insertSelective(classes);
    }

    //    修改排班信息
    @PostMapping("/update")
    @LogAnnotation(module = "排班", operator = "修改排班")
    public int updata(@PathVariable("fkId") Integer fkId,
                      @RequestBody Classes classes) {
        return classesService.updateByPrimaryKeySelective(classes);
    }

    //    删除排信息
    @GetMapping("/delect/{i}")
    @LogAnnotation(module = "排班", operator = "修改排班")
    public int delect(@PathVariable("fkId") Integer fkId,
                      @PathVariable("i") Integer integer) {
        return classesService.deleteByPrimaryKey(integer);
    }

    //    根据排班ID查找排班信息‘
    @GetMapping("/select/{i}")
    public ClassesVO select(@PathVariable("i") Integer integer) {
        return ClassesToVO.classesToVO.classesVO(classesService.selectByPrimaryKey(integer));
    }

    //    默认列表查找
    @GetMapping("/listByAll/{i}/{j}")
    public PageInfo<ClassesVO> listByAll(@PathVariable("i") Integer page,
                                         @PathVariable("j") Integer size) {
        return ClassesToVO.classesToVO.classesVOPage(classesService.listByAll(page, size));
    }
}
