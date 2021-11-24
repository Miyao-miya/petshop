package com.msyq.psetshop.vo;

import com.msyq.psetshop.pojo.PaLike;
import lombok.Data;

import java.util.Date;

@Data
public class PostAnswerVO {

    private PaLike paId;

    private PostVO fkPId;

    private PostAnswerVO pasId;

    private UsersVO fkUId;

    private String paContent;

    private Integer paClickA;

    private String paDate;

}
