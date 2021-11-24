package com.msyq.psetshop.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class Adim {
    @JsonProperty(value = "aId")
    private Integer aId;

    @JsonProperty(value = "aPassword")
    private Integer aPassword;

    @JsonProperty(value = "aName")
    private String aName;

    @JsonProperty(value = "aRoot")
    private Integer aRoot;
}