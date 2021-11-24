package com.msyq.psetshop.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class AdimLogVO {

    private Integer alId;

    private Integer fkAId;

    private String alIp;

    private String alDate;

    private String alContent;

}
