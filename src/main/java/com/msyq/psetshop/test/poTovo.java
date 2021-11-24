package com.msyq.psetshop.test;

import com.msyq.psetshop.PoToVo.UsersToVO;
import com.msyq.psetshop.pojo.Users;
import com.msyq.psetshop.vo.UsersVO;

import java.util.Date;

public class poTovo {
    public static void main(String[] args) {

//        Users users = new Users(1, 1, "12","sd","","",1, new Date());
//        UsersVO usersVO = UsersToVO.usersToVO.usersVO(users);
//        System.out.println(users);
//        System.out.println(usersVO);

        String str1 = "1";
        String[] Str1Array = str1.split("-");
        for(int i = 0; i<Str1Array.length; i ++ ){
            System.out.println(Str1Array[i]);
        }


    }
}
