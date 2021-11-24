package com.msyq.psetshop.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ErrorVO {

    private Integer eId;

    private String eIp;

    private String eNumber;

    private String eContent;

    private String eDate;

}
