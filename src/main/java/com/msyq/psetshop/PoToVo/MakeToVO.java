package com.msyq.psetshop.PoToVo;

import com.github.pagehelper.PageInfo;
import com.msyq.psetshop.PoToVo.component.MakeToVOQ;
import com.msyq.psetshop.pojo.Make;
import com.msyq.psetshop.vo.MakeVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = MakeToVOQ.class)
public interface MakeToVO {

    MakeToVO makeToVO = Mappers.getMapper(MakeToVO.class);


    @Mappings({
            @Mapping(source = "fkBId", target = "fkBId", qualifiedByName = "fkBId"),
            @Mapping(source = "fkUId", target = "fkUId", qualifiedByName = "fkUId"),
            @Mapping(source = "fkDId", target = "fkDId", qualifiedByName = "fkDId"),
            @Mapping(source = "MDate", target = "MDate", qualifiedByName = "dateToStr")
    })
    MakeVO makeVO(Make make);

    List<MakeVO> makeVOList(List<Make> makeList);

    PageInfo<MakeVO> makePage(PageInfo<Make> makeVOPageInfo);

}
