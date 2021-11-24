package com.msyq.psetshop.PoToVo;

import com.github.pagehelper.PageInfo;
import com.msyq.psetshop.PoToVo.component.PhotoCollectToVOQ;
import com.msyq.psetshop.pojo.PhotoCollect;
import com.msyq.psetshop.vo.PhotoCollectVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = PhotoCollectToVOQ.class)
public interface PhotoCollectToVO {

    PhotoCollectToVO photoCollectToVO = Mappers.getMapper(PhotoCollectToVO.class);

    @Mappings({
            @Mapping(source = "fkUId", target = "fkUId", qualifiedByName = "fkUId"),
            @Mapping(source = "pcDate", target = "pcDate", qualifiedByName = "dateToStr")
    })
    PhotoCollectVO photoCollectVO(PhotoCollect photoCollect);

    List<PhotoCollectVO> photoCollectVOList(List<PhotoCollect> photoCollectList);

    PageInfo<PhotoCollectVO> photoCollectVOPage(PageInfo<PhotoCollect> photoCollectPageInfo);

// @Mapping(source = "fkPgId", target = "fkPgId", qualifiedByName = "fkPgId"),
}
