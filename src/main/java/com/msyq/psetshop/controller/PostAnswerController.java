package com.msyq.psetshop.controller;

import com.github.pagehelper.PageInfo;
import com.msyq.psetshop.PoToVo.PostAnswerToVO;
import com.msyq.psetshop.pojo.PostAnswer;
import com.msyq.psetshop.service.PostAnswerService;
import com.msyq.psetshop.service.UsersService;
import com.msyq.psetshop.utils.aop.logAnnotation.LogAnnotation;
import com.msyq.psetshop.vo.PostAnswerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{fkId}/postanswer")
public class PostAnswerController {

    @Autowired
    private PostAnswerService postAnswerService;

    @Autowired
    private UsersService usersService;

    //    增加帖子恢复
    @PostMapping("/insert")
    @LogAnnotation(module = "帖子回复", operator = "添加")
    public int insert(@PathVariable("fkId") Integer fkId,
                      @RequestBody PostAnswer postAnswer) {
        return postAnswerService.insertSelective(postAnswer);
    }

    //    删除帖子回复
    @GetMapping("/delect/{i}/{uid}")
    @LogAnnotation(module = "帖子回复", operator = "删除")
    public int delect(@PathVariable("fkId") Integer fkId,
                      @PathVariable("i") Integer integer,
                      @PathVariable("uid") Integer uId) {

//        如果是管理员直接删除
//        如果是用户 判断 本用户删除
        return usersService.selectByPrimaryKey(uId).getUId() != null ? postAnswerService.deleteByPrimaryKey(integer) : 0;
    }

    //    根据帖子ID 回复ID 返回回复的回复列表
    @GetMapping("/findall/{pid}/{pasid}/{i}/{j}")
    public PageInfo<PostAnswerVO> findallPidAndPasid(@PathVariable("pid") Integer pid,
                                                     @PathVariable("pasid") Integer pasid,
                                                     @PathVariable("i") Integer page,
                                                     @PathVariable("j") Integer size) {
        PostAnswer postAnswer = new PostAnswer();
        postAnswer.setFkPId(pid);
        postAnswer.setPasId(pasid);
        return PostAnswerToVO.postAnswerToVO.postAnswerVOPage(postAnswerService.findByAllPidPasid(postAnswer, page, size));
    }

    //    返回帖子直接回复列表
    @GetMapping("/fiandall/{pid}/{i}/{j}")
    public PageInfo<PostAnswerVO> findallNoPasid(@PathVariable("/piod") Integer pid,
                                                 @PathVariable("i") Integer page,
                                                 @PathVariable("j") Integer size) {
        return PostAnswerToVO.postAnswerToVO.postAnswerVOPage(postAnswerService.findByAll(pid, page, size));
    }

    //    根据帖子ID 统计该帖子浏览数
    @GetMapping("/countByFkPId/{i}")
    public Integer countByFkPId(@PathVariable("i") Integer fkPId) {
        return postAnswerService.countByFkPId(fkPId);
    }

}
