package com.msyq.psetshop.controller;

import com.github.pagehelper.PageInfo;
import com.msyq.psetshop.PoToVo.MedicalToVO;
import com.msyq.psetshop.pojo.Medical;
import com.msyq.psetshop.service.MedicalService;
import com.msyq.psetshop.utils.aop.logAnnotation.LogAnnotation;
import com.msyq.psetshop.vo.MedicalVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{fkId}/Medical")
public class MedicalConttroller {

    @Autowired
    private MedicalService medicalService;

    //    添加医疗记录
    @PostMapping("/insert")
    @LogAnnotation(module = "医疗记录", operator = "添加医疗记录")
    public int insert(@PathVariable("fkId") Integer fkId,
                      @RequestBody Medical medical) {
        return medicalService.insertSelective(medical);
    }

    //    修改医疗记录
    @PostMapping("/updata")
    @LogAnnotation(module = "医疗记录", operator = "修改医疗记录")
    public int update(@PathVariable("fkId") Integer fkId,
                      @RequestBody Medical medical) {
        return medicalService.updateByPrimaryKeySelective(medical);
    }

    //    删除医疗记录
    @GetMapping("/delect/{i}")
    @LogAnnotation(module = "医疗记录", operator = "删除医疗记录")
    public int delect(@PathVariable("fkId") Integer fkId,
                      @PathVariable("i") Integer integer) {
        return medicalService.deleteByPrimaryKey(integer);
    }

    //    根据 id 查找医疗记录
    @GetMapping("/select/{i}")
    public MedicalVO select(@PathVariable("i") Integer integer) {
        return MedicalToVO.medicalToVO.medicalVO(medicalService.selectByPrimaryKey(integer));
    }

    //    根据用户 id 查找列表
    @GetMapping("/findAllByFkUId/{fkUId}/{i}/{j}")
    public PageInfo<MedicalVO> findAllByFkUId(@PathVariable("fkUId") Integer integer,
                                              @PathVariable("i") Integer page,
                                              @PathVariable("j") Integer size) {
        return MedicalToVO.medicalToVO.medicalVOPage(medicalService.findAllByFkUId(integer, page, size));
    }

    //    根据医生 id 查找列表
    @GetMapping("/findAllByFkDId/{fkDId}/{i}/{j}")
    public PageInfo<MedicalVO> findAllByFkDId(@PathVariable("fkDId") Integer fkDId,
                                              @PathVariable("i") Integer pzge,
                                              @PathVariable("j") Integer size) {
        return MedicalToVO.medicalToVO.medicalVOPage(medicalService.findAllByFkDId(fkDId, pzge, size));
    }

    //    默认 查询列表
    @GetMapping("/listByAll/{i}/{j}")
    public PageInfo<MedicalVO> listByAll(@PathVariable("i") Integer page,
                                         @PathVariable("j") Integer size) {
        return MedicalToVO.medicalToVO.medicalVOPage(medicalService.listByAll(page, size));
    }

    //    判断是否医疗过该学生
    @GetMapping("/findAllByFkUIdAndFkDId/{fkDId}")
    public int findAllByFkUIdAndFkDId(@PathVariable("fkId") Integer fkId,
                                      @PathVariable("fkDId") Integer fkDId) {
        if (medicalService.findAllByFkUIdAndFkDId(fkId, fkDId).size() > 0) {
            return 1;
        }
        return 0;
    }

}
