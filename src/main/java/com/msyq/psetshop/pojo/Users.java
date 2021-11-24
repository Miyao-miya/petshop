package com.msyq.psetshop.pojo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Users {

    @JsonProperty(value = "uId")
    private Integer uId;

    @JsonProperty(value = "uPassword")
    private String uPassword;

    @JsonProperty(value = "uName")
    private String uName;

    @JsonProperty(value = "uImg")
    private String uImg;

    @JsonProperty(value = "uInroduce")
    private String uInroduce;

    @JsonProperty(value = "uNote")
    private String uNote;

    @JsonProperty(value = "uTf")
    private Integer uTf;

    @JsonProperty(value = "uDate")
    private Date uDate;
}