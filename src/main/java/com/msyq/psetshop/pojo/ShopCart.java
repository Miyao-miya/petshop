package com.msyq.psetshop.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ShopCart {

    @JsonProperty(value = "scId")
    private Integer scId;

    @JsonProperty(value = "fkUId")
    private Integer fkUId;

    @JsonProperty(value = "fkGId")
    private Integer fkGId;

    @JsonProperty(value = "scNumber")
    private Integer scNumber;
}