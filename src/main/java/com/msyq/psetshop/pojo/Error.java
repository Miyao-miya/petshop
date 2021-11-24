package com.msyq.psetshop.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Error {

    @JsonProperty(value = "eId")
    private Integer eId;

    @JsonProperty(value = "eIp")
    private String eIp;

    @JsonProperty(value = "eNumber")
    private String eNumber;

    @JsonProperty(value = "eConten")
    private String eContent;

    @JsonProperty(value = "eDate")
    private Date eDate;
}