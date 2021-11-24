package com.msyq.psetshop.controller;

import com.github.pagehelper.PageInfo;
import com.msyq.psetshop.PoToVo.MakeToVO;
import com.msyq.psetshop.pojo.Make;
import com.msyq.psetshop.service.MakeService;
import com.msyq.psetshop.service.UsersService;
import com.msyq.psetshop.utils.aop.logAnnotation.LogAnnotation;
import com.msyq.psetshop.vo.MakeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{fkId}/make")
public class MakeController {

    @Autowired
    private MakeService makeService;


    //    添加预约
    @PostMapping("/insert")
    @LogAnnotation(module = "预约", operator = "添加预约")
    public int insert(@PathVariable("fkId") Integer fkId,
                      @RequestBody Make make) {
        return makeService.insertSelective(make);
    }

    //    修改预约
    @PostMapping("/updata")
    @LogAnnotation(module = "预约", operator = "修改预约")
    public int updata(@PathVariable("fkId") Integer fkId,
                      @RequestBody Make make) {
        return makeService.updateByPrimaryKeySelective(make);
    }

    //    删除预约
    @GetMapping("/delect/{i}")
    @LogAnnotation(module = "预约", operator = "删除预约")
    public int delect(@PathVariable("fkId") Integer fkId,
                      @PathVariable("i") Integer integer) {
        return makeService.deleteByPrimaryKey(integer);
    }

    //    根据ID查询预约
    @GetMapping("/select/{i}")
    public MakeVO select(@PathVariable("i") Integer integer) {
        return MakeToVO.makeToVO.makeVO(makeService.selectByPrimaryKey(integer));
    }

    //    分页查询预约
    @GetMapping("/findall/{i}/{j}")
    public PageInfo<MakeVO> listByAll(@PathVariable("i") Integer page,
                                      @PathVariable("j") Integer size) {
        return MakeToVO.makeToVO.makePage(makeService.listByAll(page, size));
    }

    //    根据用户ID查找预约
    @GetMapping("/findalUid/{uid}/{i}/{j}")
    public PageInfo<MakeVO> findallUid(@PathVariable("uid") Integer uid,
                                       @PathVariable("i") Integer page,
                                       @PathVariable("j") Integer size) {
        return MakeToVO.makeToVO.makePage(makeService.findAllByFkUId(uid, page, size));
    }

    //    验证用户是否已经预约过该医生
    @GetMapping("/findAllByFkUIdAndFkDId/{i}")
    public int findAllByFkUIdAndFkDId(@PathVariable("fkId")Integer fkUId,
                                      @PathVariable("i") Integer fkDId) {
        if (makeService.findAllByFkUIdAndFkDId(fkUId, fkDId).size() > 0) {
            return 1;
        }
        return 0;
    }

}
