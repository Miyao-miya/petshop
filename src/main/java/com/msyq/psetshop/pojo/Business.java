package com.msyq.psetshop.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Business {

    @JsonProperty(value = "bId")
    private Integer bId;

    @JsonProperty(value = "fkBcId")
    private Integer fkBcId;

    @JsonProperty(value = "bName")
    private String bName;

    @JsonProperty(value = "bContent")
    private String bContent;
}