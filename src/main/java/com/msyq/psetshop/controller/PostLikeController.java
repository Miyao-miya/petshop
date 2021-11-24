package com.msyq.psetshop.controller;

import com.github.pagehelper.PageInfo;
import com.msyq.psetshop.PoToVo.PostLikeToVO;
import com.msyq.psetshop.pojo.PostLike;
import com.msyq.psetshop.service.PostLikeService;
import com.msyq.psetshop.utils.aop.logAnnotation.LogAnnotation;
import com.msyq.psetshop.vo.PostLikeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{fkId}/postlike")
public class PostLikeController {

    @Autowired
    private PostLikeService postLikeService;

    //    添加浏览信息
    @PostMapping("/insert")
    @LogAnnotation(module = "帖子点赞", operator = "浏览")
    public int insert(@PathVariable("fkId") Integer fkId,
                      @RequestBody PostLike postLike) {
        return postLikeService.insertSelective(postLike);
    }

    //    修改浏览信息
    @PostMapping("/updata")
    @LogAnnotation(module = "帖子点赞", operator = "点赞")
    public int updata(@PathVariable("fkId") Integer fkId,
                      @RequestBody PostLike postLike) {
        return postLikeService.updateByPrimaryKeySelective(postLike);
    }

    //    删除浏览信息
    @GetMapping("/delect")
    @LogAnnotation(module = "帖子点赞", operator = "删除信息")
    public int delect(@PathVariable("fkId") Integer fkId,
                      @RequestBody Integer integer) {
        return postLikeService.deleteByPrimaryKey(integer);
    }


    //    查看浏览记录
    @GetMapping("/findall/{i}/{j}")
    public PageInfo<PostLikeVO> findall(@PathVariable("i") Integer page,
                                        @PathVariable("j") Integer size) {
        return PostLikeToVO.postLikeToVO.postLikeVOPage(postLikeService.listByAll(page, size));
    }

    //    统计帖子浏览
    @GetMapping("/countByFkPId/{fkPid}")
    public Integer countByFkPId(@PathVariable("fkPid") Integer fkPId) {
        return postLikeService.countByFkPId(fkPId);
    }

    //    根据发布者ID 获取其帖子浏览数
    @GetMapping("/countByFkPIdOrderByFkUId/{uid}")
    public Integer countByFkPIdOrderByFkUId(@PathVariable("uid") Integer fkPId) {
        return postLikeService.countByFkPIdOrderByFkUId(fkPId);
    }

    //    根据发布者ID 获取其帖子点赞数
    @GetMapping("/countByFkPIdOrderByFkUIdLike/{uid}")
    public Integer countByFkPIdOrderByFkUIdLike(@PathVariable("uid")Integer fkPId){
        return postLikeService.countByFkPIdOrderByFkUIdLike(fkPId);
    }

}
