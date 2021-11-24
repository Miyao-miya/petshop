package com.msyq.psetshop.controller;

import com.github.pagehelper.PageInfo;
import com.msyq.psetshop.PoToVo.UsersToVO;
import com.msyq.psetshop.pojo.Fun;
import com.msyq.psetshop.pojo.Grade;
import com.msyq.psetshop.pojo.Users;
import com.msyq.psetshop.service.FunService;
import com.msyq.psetshop.service.GradeService;
import com.msyq.psetshop.service.UsersService;
import com.msyq.psetshop.utils.aop.logAnnotation.LogAnnotation;
import com.msyq.psetshop.vo.UserInsertVO;
import com.msyq.psetshop.vo.UsersVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{fkId}/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private FunService funService;

    @Autowired
    private GradeService gradeService;

    //    账号登入
    @PostMapping("/login")
    @LogAnnotation(module = "登入", operator = "用户登入")
    public int usersLosin(@PathVariable("fkId") Integer fkId,
                          @RequestBody Users users) {
        if (usersService.selectByPrimaryKey(users.getUId()).getUPassword().equals(users.getUPassword())) {
            return 1;
        } else return 0;
    }


    //    账号注册
    @PostMapping("/insert")
    @LogAnnotation(module = "注册", operator = "用户注册")
    public int userInsert(@PathVariable("fkId") @Value("10000") Integer fkId ,
                          @RequestBody UserInsertVO userInsertVO) {
        if (usersService.listByUNote(userInsertVO.getUsers().getUNote()).size() == 0) {
            if (usersService.insertSelective(userInsertVO.getUsers()) == 1) {
//                创建账户
                Users users1 = usersService.listByUNote(userInsertVO.getUsers().getUNote()).get(0);
                Fun fun = new Fun();
                fun.setFkUId(users1.getUId());
                fun.setFPassword(userInsertVO.getPassword());
                fun.setFNumber(userInsertVO.getNumber());

                funService.insertSelective(fun);

//                创建等级
                Grade grade = new Grade();
                grade.setGId(users1.getUId());
                grade.setGNumber(1);
                grade.setGExperience(0);
                gradeService.insertSelective(grade);

                return users1.getUId();
            } else return 0;
        } else return -1;
    }

    //    账号注销  i 注销用户 j 注销等级
    @GetMapping("/delect/{i}/{j}")
    @LogAnnotation(module = "注销", operator = "用户注销")
    public int userDelect(@PathVariable("fkId") Integer fkId,
                          @PathVariable("i") Integer integer,
                          @PathVariable("j") Integer integer2) {
        if (usersService.deleteByPrimaryKey(integer) == 1) {

//            账号注销 同步 账户 等级
            if (integer2 == 1) {
//                同步 相册  帖子

            }
            return 1;
        }
        return 0;
    }


    //      忘记密码
    @PostMapping("/note")
    @LogAnnotation(module = "忘记密码", operator = "用户修改密码")
    public int userNote(@PathVariable("fkId") Integer fkId,
                        @RequestBody Users users) {
        Users users1 = usersService.listByUNote(users.getUNote()).get(0);
        if (users.getUNote().equals(users1.getUNote())) {
            if (usersService.updateByPrimaryKeySelective(users) == 1) {
                return users1.getUId();
            }
            return 0;
        }
        return -1;
    }

    //     修改信息
    @GetMapping("/update")
    @LogAnnotation(module = "修改", operator = "修改用户信息")
    public int updataUser(@PathVariable("fkId") Integer fkId,
                          @PathVariable("i") Users users) {
        return usersService.updateByPrimaryKeySelective(users);
    }


    //    查询个人信息
    @GetMapping("/select/{i}")
    @LogAnnotation(module = "查询", operator = "输出用户信息")
    public UsersVO selectUser(@PathVariable("fkId") Integer fkId,
                              @PathVariable("i") Integer integer) {
        return UsersToVO.usersToVO.usersVO(usersService.selectByPrimaryKey(integer));
    }

    //    用户默认列表输出
    @GetMapping("/findall/{i}/{j}")
    @LogAnnotation(module = "用户", operator = "默认列表输出")
    public PageInfo<UsersVO> listByAll(@PathVariable("fkId") Integer fkId,
                                       @PathVariable("i") Integer page,
                                       @PathVariable("j") Integer size) {
        return UsersToVO.usersToVO.usersPage(usersService.listByAll(page, size));
    }

    //    根据用户名查询
    @GetMapping("/findAllName/{name}/{i}/{j}")
    @LogAnnotation(module = "个人", operator = "根据用户名查询")
    public PageInfo<UsersVO> findAllName(@PathVariable("fkId") Integer fkId,
                                         @PathVariable("name") String name,
                                         @PathVariable("i") Integer page,
                                         @PathVariable("j") Integer size) {
        Users users = new Users();
        users.setUName(name);
        return UsersToVO.usersToVO.usersPage(usersService.findByAll(users, page, size));
    }
//    根据
}
