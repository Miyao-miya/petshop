package com.msyq.psetshop.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Grade {

    @JsonProperty(value = "gId")
    private Integer gId;

    @JsonProperty(value = "fkId")
    private Integer fkId;

    @JsonProperty(value = "gNumber")
    private Integer gNumber;

    @JsonProperty(value = "gExperience")
    private Integer gExperience;
}