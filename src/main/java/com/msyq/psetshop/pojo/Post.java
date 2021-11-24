package com.msyq.psetshop.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Post {

    @JsonProperty(value = "pId")
    private Integer pId;

    @JsonProperty(value = "pName")
    private String pName;

    @JsonProperty(value = "fkUId")
    private Integer fkUId;

    @JsonProperty(value = "fkTId")
    private String fkTId;

    @JsonProperty(value = "fkTypeId")
    private String fkTypeId;

    @JsonProperty(value = "pImg")
    private String pImg;

    @JsonProperty(value = "pContent")
    private String pContent;

    @JsonProperty(value = "pIssueDate")
    private Date pIssueDate;

    @JsonProperty(value = "pDate")
    private Date pDate;
}