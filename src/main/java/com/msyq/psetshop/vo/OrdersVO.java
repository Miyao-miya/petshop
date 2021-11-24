package com.msyq.psetshop.vo;

import lombok.Data;

import java.util.Date;

@Data
public class OrdersVO {
    private Integer oId;

    private GoodsVO fkGId;

    private UsersVO fkUId;

    private Integer oPrice;

    private String oDatea;

    private String oDateb;
}
