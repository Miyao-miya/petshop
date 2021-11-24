package com.msyq.psetshop.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Medical {
    @JsonProperty(value = "mId")
    private Integer mId;

    @JsonProperty(value = "fkBId")
    private Integer fkBId;

    @JsonProperty(value = "fkUId")
    private Integer fkUId;

    @JsonProperty(value = "fkDId")
    private Integer fkDId;

    @JsonProperty(value = "mDate")
    private Date mDate;

    @JsonProperty(value = "mContent")
    private String mContent;
}