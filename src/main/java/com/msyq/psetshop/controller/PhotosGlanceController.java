package com.msyq.psetshop.controller;

import com.msyq.psetshop.pojo.PhotosGlance;
import com.msyq.psetshop.service.PhotosGlanceService;
import com.msyq.psetshop.utils.aop.logAnnotation.LogAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{fkId}/photosglance")
public class PhotosGlanceController {

    @Autowired
    private PhotosGlanceService photosGlanceService;

    //    增加浏览记录
    @PostMapping("/insert")
    @LogAnnotation(module = "相册浏览", operator = "添加浏览记录")
    public int insert(@PathVariable("fkId") Integer fkId,
                      @RequestBody PhotosGlance photosGlance) {

        if (photosGlanceService.findAllByFkUIdAndFkPId(photosGlance.getFkUId(), photosGlance.getFkPId()).size() > 0){
//            更新记录
            return photosGlanceService.updateByFkUIdAndFkPId(photosGlance);
        }else {
//            添加记录
            return photosGlanceService.insertSelective(photosGlance);
        }


    }

    //    修改浏览记录
    @PostMapping("/updata")
    @LogAnnotation(module = "相册浏览", operator = "修改浏览记录")
    public int updata(@PathVariable("fkId") Integer fkId,
                      @RequestBody PhotosGlance photosGlance) {
        if (photosGlanceService.findAllByFkUIdAndFkPId(photosGlance.getFkUId(), photosGlance.getFkPId()).size() > 0){
            return photosGlanceService.updateByFkUIdAndFkPId(photosGlance);
        }
        return photosGlanceService.insertSelective(photosGlance);
    }

    //    删除浏览记录
    @GetMapping("/delect/{i}")
    @LogAnnotation(module = "相册浏览", operator = "删除浏览记录")
    public int delect(@PathVariable("fkId") Integer fkId,
                      @PathVariable("i") Integer integer) {
        return photosGlanceService.deleteByPrimaryKey(integer);
    }

    //    验证是否喜欢
    @GetMapping("/selectFkUid/{i}")
    public int findAllByFkUIdAndFkPId(@PathVariable("fkId") Integer fkId,
                                      @PathVariable("i") Integer fkPid) {

        try {
            Integer integer = photosGlanceService.findAllByFkUIdAndFkPId(fkId, fkPid).get(0).getPgTf();
            if (integer != null) {
                return integer;
            }
            return 0;
        } catch (Exception e) {
            return 0;
        }

    }

    //    统计浏览次数
    @GetMapping("/countfkpid/{i}")
    public int countFkPId(@PathVariable("i") Integer integer) {
        return photosGlanceService.countByFkPId(integer);
    }

    //    统计 喜欢/不喜欢 人数
    @GetMapping("/countByPgTf/{fkPId}/{tf}")
    public int countByPgTf(@PathVariable("fkPId") Integer fkPId,
                           @PathVariable("tf") Integer integer) {
        return photosGlanceService.countByFkPIdAndPgTf(fkPId, integer);
    }

}
