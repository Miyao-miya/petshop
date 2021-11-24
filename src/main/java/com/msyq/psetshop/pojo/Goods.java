package com.msyq.psetshop.pojo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Goods {

    @JsonProperty(value = "gId")
    private Integer gId;

    @JsonProperty(value = "gName")
    private String gName;

    @JsonProperty(value = "fkGcId")
    private String fkGcId;

    @JsonProperty(value = "fkTypeId")
    private String fkTypeId;

    @JsonProperty(value = "gContent")
    private String gContent;

    @JsonProperty(value = "gPrice")
    private Integer gPrice;

    @JsonProperty(value = "gImg")
    private String gImg;

    @JsonProperty(value = "gImgs")
    private String gImgs;
}