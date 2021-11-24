package com.msyq.psetshop.PoToVo;

import com.github.pagehelper.PageInfo;
import com.msyq.psetshop.PoToVo.component.GoodsToVOQ;
import com.msyq.psetshop.PoToVo.component.OrdersToVOQ;
import com.msyq.psetshop.pojo.Orders;
import com.msyq.psetshop.vo.OrdersVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = OrdersToVOQ.class)
public interface OrdersToVO {

    OrdersToVO ordersToVO = Mappers.getMapper(OrdersToVO.class);


    @Mappings({
            @Mapping(source = "fkGId", target = "fkGId", qualifiedByName = "fkGId"),
            @Mapping(source = "fkUId", target = "fkUId", qualifiedByName = "fkUId"),
            @Mapping(source = "ODatea", target = "ODatea", qualifiedByName = "dateToStr"),
            @Mapping(source = "ODateb", target = "ODateb", qualifiedByName = "dateToStr"),
    })
    OrdersVO ordersVO(Orders orders);

    List<OrdersVO> ordersVOList(List<Orders> ordersList);

    PageInfo<OrdersVO> oedersPage(PageInfo<Orders> ordersPageInfo);

}
