package com.msyq.psetshop.PoToVo.component;

import com.msyq.psetshop.PoToVo.UsersToVO;
import com.msyq.psetshop.pojo.PaLike;
import com.msyq.psetshop.pojo.PostAnswer;
import com.msyq.psetshop.service.PaLikeService;
import com.msyq.psetshop.service.PostAnswerService;
import com.msyq.psetshop.service.PostService;
import com.msyq.psetshop.service.UsersService;
import com.msyq.psetshop.utils.date.DateTimeUtils;
import com.msyq.psetshop.vo.PostAnswerVO;
import com.msyq.psetshop.vo.PostVO;
import com.msyq.psetshop.vo.UsersVO;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

@Component
public class PostAnswerToVOQ {

    public static  PostAnswerToVOQ postAnswerToVOQ;

    @Autowired
    private PostService postService;

    @Autowired
    private PostAnswerService postAnswerService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private PaLikeService paLikeService;

    @PostConstruct
    public void init(){
       postAnswerToVOQ = this;
       postAnswerToVOQ.postAnswerService = this.postAnswerService;
       postAnswerToVOQ.postService = this.postService;
       postAnswerToVOQ.usersService = this.usersService;
       postAnswerToVOQ.paLikeService = this.paLikeService;
    }

    @Named("fkPId")
    public PostVO fkPId(Integer integer){
        return null;
    }

    @Named("pasId")
    public PostAnswerVO pasId(Integer integer){
        return null;
    }

    @Named("fkUId")
    public UsersVO fkUId(Integer integer){
        if (integer == null){
            return null;
        }
        return UsersToVO.usersToVO.usersVO(postAnswerToVOQ.usersService.selectByPrimaryKey(integer));
    }

    @Named("dateToStr")
    public String dateToStr(Date date){
        if (date == null){
            return null;
        }
        return DateTimeUtils.DATE_TIME.formatDate(date);
    }

    @Named("paId")
    public PaLike paId(Integer integer){
        if (integer == null){
            return null;
        }
        return postAnswerToVOQ.paLikeService.selectByPrimaryKey(integer);
    }

}
