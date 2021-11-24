package com.msyq.psetshop.vo;

import lombok.Data;

import java.util.Date;

@Data
public class PostLikeVO {

    private Integer plId;

    private PostVO fkPId;

    private UsersVO fkUId;

    private Integer plTf;

    private String plClickDate;

    private String plDate;

}
