package com.msyq.psetshop.controller;

import com.github.pagehelper.PageInfo;
import com.msyq.psetshop.PoToVo.DoctorToVO;
import com.msyq.psetshop.PoToVo.UsersToVO;
import com.msyq.psetshop.pojo.Doctor;
import com.msyq.psetshop.service.DoctorService;
import com.msyq.psetshop.utils.aop.logAnnotation.LogAnnotation;
import com.msyq.psetshop.vo.DoctorVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{fkId}/dockor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    //    医生账号注册
    @PostMapping("/insert")
    @LogAnnotation(module = "医生", operator = "添加医生")
    public int doctorinsert(@PathVariable("fkId") Integer fkId,
                            @RequestBody Doctor doctor) {
        return doctorService.insertSelective(doctor);
    }

//    修改医生信息
    @PostMapping("/update")
    @LogAnnotation(module = "医生", operator = "修改医生信息")
    public int updateByPrimaryKeySelective(@PathVariable("fkId") Integer fkId,
                                           @RequestBody Doctor doctor){
        return doctorService.updateByPrimaryKeySelective(doctor);
    }

    //    删除医生
    @GetMapping("/delect/{i}")
    @LogAnnotation(module = "删除医生", operator = "删除医生")
    public int doctordelect(@PathVariable("fkId") Integer fkId,
                            @PathVariable("i") Integer integer) {
//        classesService.delectfkdid(integer);
//        makeService.delectfkdid(integer);
        return doctorService.deleteByPrimaryKey(integer);
    }

    //     查询医生
    @GetMapping("/select/{i}")
    public  DoctorVO doctorselect(@PathVariable("i")Integer integer){
        return DoctorToVO.doctorToVO.doctorVO(doctorService.selectByPrimaryKey(integer));
    }


    //    返回医生分页列表
    //    @LogAnnotation(module = "医生", operator = "分页查询")
    @GetMapping("/findall/{i}/{j}")
    public PageInfo<DoctorVO> findAll(@PathVariable("i") Integer page, @PathVariable("j") Integer size){
        PageInfo<Doctor> doctor = doctorService.findAll(new Doctor(),page,size);
        return DoctorToVO.doctorToVO.pageInfoVO(doctor);
    }

}
