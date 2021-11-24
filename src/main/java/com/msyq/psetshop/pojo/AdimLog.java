package com.msyq.psetshop.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AdimLog {

    @JsonProperty(value = "alId")
    private Integer alId;

    @JsonProperty(value = "fkAId")
    private Integer fkAId;

    @JsonProperty(value = "alIp")
    private String alIp;

    @JsonProperty(value = "alDate")
    private Date alDate;

    @JsonProperty(value = "alContent")
    private String alContent;
}