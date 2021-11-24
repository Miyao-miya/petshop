package com.msyq.psetshop.PoToVo;

import com.github.pagehelper.PageInfo;
import com.msyq.psetshop.PoToVo.component.GoodsToVOQ;
import com.msyq.psetshop.mapper.GoodsCategoryMapper;
import com.msyq.psetshop.pojo.Goods;
import com.msyq.psetshop.pojo.GoodsCategory;
import com.msyq.psetshop.pojo.Type;
import com.msyq.psetshop.service.GoodsCategoryService;
import com.msyq.psetshop.service.TypeService;
import com.msyq.psetshop.utils.date.DateTimeUtils;
import com.msyq.psetshop.vo.GoodsVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Mapper(uses = GoodsToVOQ.class)
public interface GoodsToVO{

    GoodsToVO goodsToVO = Mappers.getMapper(GoodsToVO.class);

    @Mappings({
            @Mapping(source = "fkGcId", target = "fkGcId", qualifiedByName = "fkGcId"),
            @Mapping(source = "fkTypeId", target = "fkTypeId", qualifiedByName = "fkTypeId"),
            @Mapping(source = "GImgs", target = "GImgs", qualifiedByName = "gImgs")
    })
    GoodsVO goodsVO(Goods goods);

    List<GoodsVO> goodsListVO(List<Goods> goodsVOS);

    PageInfo<GoodsVO> goodsPage(PageInfo<Goods> goodsPageInfo);

}
