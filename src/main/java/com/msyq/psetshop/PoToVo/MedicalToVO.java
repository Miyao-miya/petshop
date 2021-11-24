package com.msyq.psetshop.PoToVo;

import com.github.pagehelper.PageInfo;
import com.msyq.psetshop.PoToVo.component.MedicalToVOQ;
import com.msyq.psetshop.pojo.Medical;
import com.msyq.psetshop.vo.MedicalVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = MedicalToVOQ.class)
public interface MedicalToVO {

    MedicalToVO medicalToVO = Mappers.getMapper(MedicalToVO.class);


    @Mappings({
            @Mapping(source = "fkBId", target = "fkBId", qualifiedByName = "fkBId"),
            @Mapping(source = "fkUId", target = "fkUId", qualifiedByName = "fkUId"),
            @Mapping(source = "fkDId", target = "fkDId", qualifiedByName = "fkDId"),
            @Mapping(source = "MDate", target = "MDate", qualifiedByName = "dateToStr"),
    })
    MedicalVO medicalVO(Medical medical);

    List<MedicalVO> medicalVOList(List<Medical> medicals);

    PageInfo<MedicalVO> medicalVOPage(PageInfo<Medical> medicalPageInfo);

}
