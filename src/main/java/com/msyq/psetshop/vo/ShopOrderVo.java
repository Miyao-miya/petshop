package com.msyq.psetshop.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.msyq.psetshop.pojo.Orders;
import com.msyq.psetshop.pojo.Users;
import lombok.Data;

import java.util.List;

@Data
public class ShopOrderVo {

    @JsonProperty(value = "fkUId")
    private Integer fkUId;

    @JsonProperty(value = "password")
    private String password;

    @JsonProperty(value = "orders")
    private Orders orders;

}
