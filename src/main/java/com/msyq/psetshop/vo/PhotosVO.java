package com.msyq.psetshop.vo;

import com.msyq.psetshop.pojo.PhotosGlance;
import com.msyq.psetshop.pojo.Type;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PhotosVO {

    private Integer pId;

    private String pName;

    private UsersVO fkUId;

    private String pImg;

    private List<String> pConent;

    private List<Type> pType;

    private String pDate;

}
