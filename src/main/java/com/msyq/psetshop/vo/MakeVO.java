package com.msyq.psetshop.vo;

import lombok.Data;

import java.util.Date;

@Data
public class MakeVO {

    private Integer mId;

    private BusinessVO fkBId;

    private UsersVO fkUId;

    private DoctorVO fkDId;

    private String mDate;

    private String mContent;

}
