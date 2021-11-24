package com.msyq.psetshop.controller;


import com.msyq.psetshop.PoToVo.GradeToVO;
import com.msyq.psetshop.pojo.Grade;
import com.msyq.psetshop.service.GradeService;
import com.msyq.psetshop.utils.aop.logAnnotation.LogAnnotation;
import com.msyq.psetshop.vo.GradeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{fkId}/Grade")
public class GradeController {

    @Autowired
    private GradeService gradeService;


    /*
    * 添加等级信息
    *
    * 在账号注册时同步
    * */

//    修改等级信息
    @PostMapping("/updata")
    @LogAnnotation(module = "等级", operator = "等级信息修改")
    public int updata(@RequestBody Grade grade){
        return gradeService.updateByPrimaryKeySelective(grade);
    }

    /**
     * 删除等级信息
     *
     * 在账号删除是同步
     * */


//    查看用户等级信息
    @GetMapping("/findAllByFkId/{i}")
    public GradeVO findAllByFkId(@PathVariable("i") Integer integer){
        if (gradeService.findAllByFkId(integer).size()>0){
            return GradeToVO.gradeToVO.gradeVO(gradeService.findAllByFkId(integer).get(0));
        }return  GradeToVO.gradeToVO.gradeVO(new Grade());
    }

}
