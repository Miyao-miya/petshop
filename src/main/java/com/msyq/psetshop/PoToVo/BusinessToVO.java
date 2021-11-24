package com.msyq.psetshop.PoToVo;

import com.github.pagehelper.PageInfo;
import com.msyq.psetshop.PoToVo.component.BusinessToVOQ;
import com.msyq.psetshop.pojo.Business;
import com.msyq.psetshop.vo.BusinessVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = BusinessToVOQ.class)
public interface BusinessToVO {

    BusinessToVO businessToVO = Mappers.getMapper(BusinessToVO.class);

    @Mappings({
            @Mapping(source = "fkBcId", target = "fkBcId", qualifiedByName = "fkBcId")
    })
    BusinessVO businessVO(Business business);

    List<BusinessVO> businessVOList(List<Business> businessList);

    PageInfo<BusinessVO> businessVOPage(PageInfo<Business> businessPageInfo);

}
