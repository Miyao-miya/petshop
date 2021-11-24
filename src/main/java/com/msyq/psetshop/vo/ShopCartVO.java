package com.msyq.psetshop.vo;

import lombok.Data;

@Data
public class ShopCartVO {

    private Integer scId;

    private UsersVO fkUId;

    private GoodsVO fkGId;

    private Integer scNumber;

}
