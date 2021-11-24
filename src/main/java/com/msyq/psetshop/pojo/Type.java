package com.msyq.psetshop.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Type {

    @JsonProperty(value = "tId")
    private Integer tId;

    @JsonProperty(value = "tName")
    private String tName;

    @JsonProperty(value = "tNote")
    private String tNote;
}