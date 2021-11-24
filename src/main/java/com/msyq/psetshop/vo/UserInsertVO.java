package com.msyq.psetshop.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.msyq.psetshop.pojo.Users;
import lombok.Data;

@Data
public class UserInsertVO {

    @JsonProperty("users")
    private Users users;

    @JsonProperty("password")
    private String password;

    @JsonProperty("number")
    private Integer number;

}
