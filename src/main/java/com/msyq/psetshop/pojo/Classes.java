package com.msyq.psetshop.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;


@Data
public class Classes {

    @JsonProperty(value = "cId")
    private Integer cId;

    @JsonProperty(value = "fkDId")
    private Integer fkDId;

    @JsonProperty(value = "cDatea")
    private Date cDatea;

    @JsonProperty(value = "cDateb")
    private Date cDateb;

    @JsonProperty(value = "cTf")
    private Integer cTf;
}