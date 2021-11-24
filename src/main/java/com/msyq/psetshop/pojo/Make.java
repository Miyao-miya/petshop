package com.msyq.psetshop.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Make {

    @JsonProperty(value = "mId")
    private Integer mId;

    @JsonProperty(value = "fkBId")
    private Integer fkBId;

    @JsonProperty(value = "fkUId")
    private Integer fkUId;

    @JsonProperty(value = "fkDId")
    private Integer fkDId;

    @JsonProperty(value = "mDate")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date mDate;

    @JsonProperty(value = "mContent")
    private String mContent;
}