package com.msyq.psetshop.PoToVo.component;

import com.msyq.psetshop.PoToVo.UsersToVO;
import com.msyq.psetshop.pojo.Topic;
import com.msyq.psetshop.pojo.Type;
import com.msyq.psetshop.service.TopicService;
import com.msyq.psetshop.service.TypeService;
import com.msyq.psetshop.service.UsersService;
import com.msyq.psetshop.utils.date.DateTimeUtils;
import com.msyq.psetshop.vo.UsersVO;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class PostToVOQ {

    private static PostToVOQ postToVOQ;

    @Autowired
    private UsersService usersService;

    @Autowired
    private TopicService topicService;

    @Autowired
    private TypeService typeService;

    @PostConstruct
    public void init(){
        postToVOQ = this;
        postToVOQ.topicService = this.topicService;
        postToVOQ.typeService = this.typeService;
        postToVOQ.usersService = this.usersService;
    }

    @Named("fkTypeId")
    public List<Type> fkTypeId(String str) {
        if (str != null) {
            String[] strings = str.split("-");
            List<Type> goodsCategories = new ArrayList<>();

            for (String gc : strings) {
                if (!gc.equals(null)) {
                    goodsCategories.add(postToVOQ.typeService.selectByPrimaryKey(Integer.parseInt(gc)));
                }
            }

            return goodsCategories;
        }
        return null;
    }

    @Named("fkTId")
    public List<Topic> fkTId(String str) {
        if (str != null) {
            String[] strings = str.split("-");
            List<Topic> goodsCategories = new ArrayList<>();

            for (String gc : strings) {
                if (!gc.equals(null)) {
                    goodsCategories.add(postToVOQ.topicService.selectByPrimaryKey(Integer.parseInt(gc)));
                }
            }

            return goodsCategories;
        }
        return null;
    }

    @Named("fkUId")
    public UsersVO fkUId(Integer integer){
        if (integer == null){
            return null;
        }
        return UsersToVO.usersToVO.usersVO(postToVOQ.usersService.selectByPrimaryKey(integer));
    }

    @Named("dateToStr")
    public String dateToStr(Date date){
        if (date == null){
            return null;
        }
        return DateTimeUtils.DATE.formatDate(date);
    }

}
