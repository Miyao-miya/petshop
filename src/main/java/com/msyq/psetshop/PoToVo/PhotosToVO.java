package com.msyq.psetshop.PoToVo;

import com.github.pagehelper.PageInfo;
import com.msyq.psetshop.PoToVo.component.PhotosToVOQ;
import com.msyq.psetshop.pojo.Photos;
import com.msyq.psetshop.vo.PhotosVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = PhotosToVOQ.class)
public interface PhotosToVO {

    PhotosToVO photosToVO = Mappers.getMapper(PhotosToVO.class);


    @Mappings({
            @Mapping(source = "fkUId", target = "fkUId", qualifiedByName = "fkUId"),
            @Mapping(source = "PType", target = "PType", qualifiedByName = "pType"),
            @Mapping(source = "PConent", target = "PConent", qualifiedByName = "pConent"),
            @Mapping(source = "PDate", target = "PDate", qualifiedByName = "dateToStr"),
    })
    PhotosVO photosVo(Photos photos);

    List<PhotosVO> photosVOList(List<Photos> photos);

    PageInfo<PhotosVO> photosVOPage(PageInfo<Photos> photosPageInfo);

}
