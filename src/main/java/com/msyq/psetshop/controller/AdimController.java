package com.msyq.psetshop.controller;

import com.github.pagehelper.PageInfo;
import com.msyq.psetshop.pojo.Adim;
import com.msyq.psetshop.service.AdimService;
import com.msyq.psetshop.utils.aop.logAnnotation.LogAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{fkId}/adim")
public class AdimController {

    @Autowired
    private AdimService adimService;

    //   添加管理员
    @PostMapping("/insert")
    @LogAnnotation(module = "管理员", operator = "添加管理员")
    public int insert(@PathVariable("fkId") Integer fkId,
                      @RequestBody Adim adim) {
        return adimService.insertSelective(adim);
    }

    //    修改管管理员信息
    @PostMapping("/updata")
    @LogAnnotation(module = "管理员", operator = "修改管理员")
    public int update(@PathVariable("fkId") Integer fkId,
                      @RequestBody Adim adim) {
        return adimService.updateByPrimaryKeySelective(adim);
    }


    //    删除管理员信息
    @GetMapping("/delect/{i}")
    @LogAnnotation(module = "管理员", operator = "删除管理员")
    public int delect(@PathVariable("fkId") Integer fkId,
                      @PathVariable("i") Integer integer) {
        return adimService.deleteByPrimaryKey(integer);
    }

    //    登入
    @PostMapping("/login")
    @LogAnnotation(module = "管理员", operator = "管理员登入")
    public int login(@PathVariable("fkId") Integer fkId,
                     @RequestBody Adim adim) {
        if (adimService.findAllByAIdAndAPassword(adim.getAId(), adim.getAPassword()).size() > 0) {
            return 1;
        } else return 0;
    }

    //   根据管路员ID 查找管理员
    @GetMapping("/select/{i}")
    @LogAnnotation(module = "管理员", operator = "根据管路员ID 查找管理员")
    public Adim select(@PathVariable("fkId") Integer fkId,
                       @PathVariable("i") Integer integer) {
        return adimService.selectByPrimaryKey(integer);
    }

    //    查找其他管路员列表  权限低于自己
    @GetMapping("/findAllByARoot/{root}/{i}/{j}")
    @LogAnnotation(module = "管理员", operator = "根据管路员ID 查找其他管路员列表")
    public PageInfo<Adim> findAllByARoot(@PathVariable("fkId") Integer fkId,
                                         @PathVariable("root") String aRoot,
                                         @PathVariable("i") Integer page,
                                         @PathVariable("j") Integer size){
        return adimService.findAllByARoot(aRoot, page, size);
    }

}
