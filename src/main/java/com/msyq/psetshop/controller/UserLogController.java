package com.msyq.psetshop.controller;

import com.github.pagehelper.PageInfo;
import com.msyq.psetshop.PoToVo.UserLogToVO;
import com.msyq.psetshop.pojo.UserLog;
import com.msyq.psetshop.service.UserLogService;
import com.msyq.psetshop.utils.aop.logAnnotation.LogAnnotation;
import com.msyq.psetshop.vo.UserLogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/{fkId}/UserLog")
public class UserLogController {

    @Autowired
    private UserLogService userLogService;

    //    删除日志
    @GetMapping("/delect/{i}")
    @LogAnnotation(module = "用戶日志", operator = "删除")
    public int delect(@PathVariable("fkId") Integer fkId,
                      @PathVariable("i") Integer integer) {
        return userLogService.deleteByPrimaryKey(integer);
    }

//    查询日志
    @GetMapping("/listByAll/{i}/{j}")
    @LogAnnotation(module = "用戶日志", operator = "查询")
    public PageInfo<UserLogVO> listByAll(@PathVariable("fkId") Integer fkId,
                                         @PathVariable("i") Integer page,
                                         @PathVariable("j") Integer size) {
        return UserLogToVO.usersToVO.userLogVOPage(userLogService.listByAll(page, size));
    }


}
