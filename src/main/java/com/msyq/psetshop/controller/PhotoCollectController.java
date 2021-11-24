package com.msyq.psetshop.controller;

import com.github.pagehelper.PageInfo;
import com.msyq.psetshop.PoToVo.PhotoCollectToVO;
import com.msyq.psetshop.pojo.PhotoCollect;
import com.msyq.psetshop.service.PhotoCollectService;
import com.msyq.psetshop.utils.aop.logAnnotation.LogAnnotation;
import com.msyq.psetshop.vo.PhotoCollectVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{fkId}/photocollect")
public class PhotoCollectController {

    @Autowired
    private PhotoCollectService photoCollectService;

    //    增加帖子收藏
    @PostMapping("/insert")
    @LogAnnotation(module = "相册收藏", operator = "收藏")
    public int insert(@PathVariable("fkId") Integer fkId,
                      @RequestBody PhotoCollect photoCollect) {
        return photoCollectService.insertSelective(photoCollect);
    }

    //    修改帖子收藏信息
    @PostMapping("/updata")
    @LogAnnotation(module = "相册收藏", operator = "修改")
    public int updata(@RequestBody PhotoCollect photoCollect) {

        if (photoCollectService.findAllByFkUIdAndFkPgId(photoCollect.getFkUId(), photoCollect.getFkPgId()).size() > 0) {
            return photoCollectService.updateByFkUIdAndFkPgId(photoCollect);
        } else {
            return photoCollectService.insertSelective(photoCollect);
        }
    }

    //    取消收藏
    @GetMapping("/delect/{i}")
    @LogAnnotation(module = "相册收藏", operator = "取消收藏")
    public int delect(@PathVariable("fkId") Integer fkId,
                      @PathVariable("i") Integer integer) {
        return photoCollectService.deleteByPrimaryKey(integer);
    }

    //    根据用户id 相册id取消收藏
    @GetMapping("/deleteByFkUIdAndFkPgId/{i}")
    @LogAnnotation(module = "相册收藏", operator = "据用户id 相册id 取消收藏")
    public int deleteByFkUIdAndFkPgId(@PathVariable("fkId") Integer fkUId,
                                      @PathVariable("i") Integer fkPgId) {
        return photoCollectService.deleteByFkUIdAndFkPgId(fkUId, fkPgId);
    }

    //    根据ID查询帖子收藏信息
    @GetMapping("/select/{i}")
    public PhotoCollectVO select(@PathVariable("i") Integer integer) {
        return PhotoCollectToVO.photoCollectToVO.photoCollectVO(photoCollectService.selectByPrimaryKey(integer));
    }

    //    收藏分页
    @GetMapping("/findall/{i}/{j}")
    public PageInfo<PhotoCollectVO> findall(@PathVariable("i") Integer page,
                                            @PathVariable("j") Integer size) {
        return PhotoCollectToVO.photoCollectToVO.photoCollectVOPage(photoCollectService.listByAll(page, size));
    }

    //    验证是否收藏
    @GetMapping("/findAllByFkUIdAndFkPgId/{i}")
    public int findAllByFkUIdAndFkPgId(@PathVariable("fkId") Integer fkUId,
                                       @PathVariable("i") Integer fkPgId) {
        if (photoCollectService.findAllByFkUIdAndFkPgId(fkUId, fkPgId).size() > 0) {
            return 1;
        }
        return 0;
    }

    //    该帖子的收藏人数
    @GetMapping("/countByFkPgId/{fkPgId}")
    public int countByFkPgId(@PathVariable("fkPgId") Integer fkPgId) {
        return photoCollectService.countByFkPgId(fkPgId);
    }

}
