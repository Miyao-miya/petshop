package com.msyq.psetshop.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class UserLogVO {


    private Integer ulId;

    private Integer fkUId;

    private String ulIp;

    private String ulDate;

    private String ulContent;

}
