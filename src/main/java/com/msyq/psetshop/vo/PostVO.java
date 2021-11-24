package com.msyq.psetshop.vo;

import com.msyq.psetshop.pojo.Topic;
import com.msyq.psetshop.pojo.Type;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PostVO {

    private Integer pId;

    private String pName;

    private UsersVO fkUId;

    private List<Topic> fkTId;

    private List<Type> fkTypeId;

    private String pImg;

    private String pContent;

    private String pIssueDate;

    private String pDate;

}
