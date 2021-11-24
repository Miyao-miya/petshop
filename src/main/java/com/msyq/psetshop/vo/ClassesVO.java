package com.msyq.psetshop.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ClassesVO {

    private Integer cId;

    private Integer fkDId;

    private String cDatea;

    private String cDateb;

    private Integer cTf;

}
