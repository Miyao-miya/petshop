package com.msyq.psetshop.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PostAnswer {

    @JsonProperty(value = "paId")
    private Integer paId;

    @JsonProperty(value = "fkPId")
    private Integer fkPId;

    @JsonProperty(value = "pasId")
    private Integer pasId;

    @JsonProperty(value = "fkUId")
    private Integer fkUId;

    @JsonProperty(value = "fkUIdB")
    private Integer fkUIdB;

    @JsonProperty(value = "paContent")
    private String paContent;

    @JsonProperty(value = "paClickA")
    private Integer paClickA;

    @JsonProperty(value = "paDate")
    private Date paDate;
}