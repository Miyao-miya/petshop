package com.msyq.psetshop.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GradeVO {

    private Integer gId;

    private UsersVO fkId;

    private Integer gNumber;

    private Integer gExperience;

}
