package com.msyq.psetshop.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PhotosGlance {

    @JsonProperty(value = "pgId")
    private Integer pgId;

    @JsonProperty(value = "fkPId")
    private Integer fkPId;

    @JsonProperty(value = "fkUId")
    private Integer fkUId;

    @JsonProperty(value = "pgTf")
    private Integer pgTf;

    @JsonProperty(value = "pgDate")
    private Date pgDate;
}