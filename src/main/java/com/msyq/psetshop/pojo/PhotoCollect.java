package com.msyq.psetshop.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PhotoCollect {

    @JsonProperty(value = "pcId")
    private Integer pcId;

    @JsonProperty(value = "fkUId")
    private Integer fkUId;

    @JsonProperty(value = "fkPgId")
    private Integer fkPgId;

    @JsonProperty(value = "pcDate")
    private Date pcDate;
}