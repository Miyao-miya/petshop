package com.msyq.psetshop.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Doctor {

    @JsonProperty(value = "dId")
    private Integer dId;

    @JsonProperty(value = "dPassword")
    private Integer dPassword;

    @JsonProperty(value = "dName")
    private String dName;

    @JsonProperty(value = "dImg")
    private String dImg;

    @JsonProperty(value = "dInroduce")
    private String dInroduce;

    @JsonProperty(value = "uTf")
    private Integer uTf;

    @JsonProperty(value = "dDate")
    private Date dDate;
}