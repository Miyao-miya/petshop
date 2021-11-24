package com.msyq.psetshop.PoToVo.component;

import com.msyq.psetshop.PoToVo.PostToVO;
import com.msyq.psetshop.PoToVo.UsersToVO;
import com.msyq.psetshop.service.PostService;
import com.msyq.psetshop.service.UsersService;
import com.msyq.psetshop.utils.date.DateTimeUtils;
import com.msyq.psetshop.vo.PostVO;
import com.msyq.psetshop.vo.UsersVO;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

@Component
public class PostLikeToVOQ {

    public static PostLikeToVOQ postLikeToVOQ;

    @Autowired
    private UsersService usersService;

    @Autowired
    private PostService postService;

    @PostConstruct
    public void init(){
        postLikeToVOQ = this;
        postLikeToVOQ.usersService = this.usersService;
        postLikeToVOQ.postService = this.postService;
    }

    @Named("fkPId")
    public PostVO fkPId(Integer integer){
//        if (integer == null){
//            return null;
//        }
//        return PostToVO.postToVO.postVO(postLikeToVOQ.postService.selectByPrimaryKey(integer));

        return null;
    }

    @Named("fkUId")
    public UsersVO fkUId(Integer integer){
        if (integer == null){
            return null;
        }
        return UsersToVO.usersToVO.usersVO(postLikeToVOQ.usersService.selectByPrimaryKey(integer));
    }

    @Named("dateToStr")
    public String dateToStr(Date date){
        if (date == null){
            return null;
        }
        return DateTimeUtils.DATE_TIME.formatDate(date);
    }

}
