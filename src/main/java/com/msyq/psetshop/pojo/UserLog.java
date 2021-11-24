package com.msyq.psetshop.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserLog {

    @JsonProperty(value = "ulId")
    private Integer ulId;

    @JsonProperty(value = "fkUId")
    private Integer fkUId;

    @JsonProperty(value = "ulIp")
    private String ulIp;

    @JsonProperty(value = "ulDate")
    private Date ulDate;

    @JsonProperty(value = "ulContent")
    private String ulContent;
}