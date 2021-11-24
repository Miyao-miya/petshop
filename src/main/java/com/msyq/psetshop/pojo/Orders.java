package com.msyq.psetshop.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Orders {

    @JsonProperty(value = "oId")
    private Integer oId;

    @JsonProperty(value = "fkGId")
    private Integer fkGId;

    @JsonProperty(value = "fkUId")
    private Integer fkUId;

    @JsonProperty(value = "oPrice")
    private Integer oPrice;

    @JsonProperty(value = "oDatea")
    private Date oDatea;

    @JsonProperty(value = "oDateb")
    private Date oDateb;
}