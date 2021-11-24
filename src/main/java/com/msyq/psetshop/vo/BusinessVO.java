package com.msyq.psetshop.vo;

import com.msyq.psetshop.pojo.BusinessCategory;
import lombok.Data;

@Data
public class BusinessVO {

    private Integer bId;

    private BusinessCategory fkBcId;

    private String bName;

    private String bContent;

}
