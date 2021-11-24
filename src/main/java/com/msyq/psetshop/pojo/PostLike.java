package com.msyq.psetshop.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PostLike {

    @JsonProperty(value = "plId")
    private Integer plId;

    @JsonProperty(value = "fkPId")
    private Integer fkPId;

    @JsonProperty(value = "fkUId")
    private Integer fkUId;

    @JsonProperty(value = "plTf")
    private Integer plTf;

    @JsonProperty(value = "plClickDate")
    private Date plClickDate;

    @JsonProperty(value = "plDate")
    private Date plDate;
}