package com.msyq.psetshop.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Fun {

    @JsonProperty(value = "fId")
    private Integer fId;

    @JsonProperty(value = "fkUId")
    private Integer fkUId;

    @JsonProperty(value = "fPassword")
    private String fPassword;

    @JsonProperty(value = "fNumber")
    private Integer fNumber;
}