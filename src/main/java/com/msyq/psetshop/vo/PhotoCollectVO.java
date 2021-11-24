package com.msyq.psetshop.vo;

import lombok.Data;

import java.util.Date;

@Data
public class PhotoCollectVO {

    private Integer pcId;

    private UsersVO fkUId;

    private Integer fkPgId;

    private String pcDate;

}
