package com.msyq.psetshop.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GoodsCategory {
    @JsonProperty(value = "gcId")
    private Integer gcId;

    @JsonProperty(value = "gcName")
    private String gcName;

    @JsonProperty(value = "scNote")
    private String scNote;
}