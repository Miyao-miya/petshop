package com.msyq.psetshop.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PaLike {

    @JsonProperty(value = "palId")
    private Integer palId;

    @JsonProperty(value = "fkPaId")
    private Integer fkPaId;

    @JsonProperty(value = "fkUId")
    private Integer fkUId;

    @JsonProperty(value = "palTf")
    private Integer palTf;

    @JsonProperty(value = "palDate")
    private Date palDate;
}