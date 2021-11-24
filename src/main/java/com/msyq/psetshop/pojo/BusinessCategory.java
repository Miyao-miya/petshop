package com.msyq.psetshop.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BusinessCategory {

    @JsonProperty(value = "bcId")
    private Integer bcId;

    @JsonProperty(value = "bcName")
    private String bcName;

    @JsonProperty(value = "bcNote")
    private String bcNote;
}