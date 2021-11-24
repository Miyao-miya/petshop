package com.msyq.psetshop.PoToVo;

import com.github.pagehelper.PageInfo;
import com.msyq.psetshop.PoToVo.component.ShopCartToVOQ;
import com.msyq.psetshop.pojo.ShopCart;
import com.msyq.psetshop.vo.ShopCartVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = ShopCartToVOQ.class)
public interface ShopCartToVO {

    ShopCartToVO shopCartToVO = Mappers.getMapper(ShopCartToVO.class);


    @Mappings({
            @Mapping(source = "fkGId", target = "fkGId", qualifiedByName = "fkGId"),
            @Mapping(source = "fkUId", target = "fkUId", qualifiedByName = "fkUId"),
            @Mapping(source = "scNumber", target = "scNumber", qualifiedByName = "intNoNull")
    })
    ShopCartVO shopCartVO(ShopCart shopCart);

    List<ShopCartVO> shopCartVOList(List<ShopCart> shopCartList);

    PageInfo<ShopCartVO> shopCartPage(PageInfo<ShopCart> shopCartList);

}
