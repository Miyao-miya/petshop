package com.msyq.psetshop.vo;

import com.msyq.psetshop.pojo.Users;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UsersVO {
    private Integer uId;

    private String uPassword;

    private String uName;

    private String uImg;

    private String uInroduce;

    private String uNote;

    private Integer uTf;

    private String udate;
}
