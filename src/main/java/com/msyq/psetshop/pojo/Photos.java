package com.msyq.psetshop.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Photos {

    @JsonProperty(value = "pId")
    private Integer pId;

    @JsonProperty(value = "pName")
    private String pName;

    @JsonProperty(value = "fkUId")
    private Integer fkUId;

    @JsonProperty(value = "pImg")
    private String pImg;

    @JsonProperty(value = "pConent")
    private String pConent;

    @JsonProperty(value = "pType")
    private String pType;

    @JsonProperty(value = "pDate")
    private Date pDate;
}