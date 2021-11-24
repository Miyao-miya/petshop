package com.msyq.psetshop.PoToVo.component;

import com.msyq.psetshop.PoToVo.PhotosToVO;
import com.msyq.psetshop.PoToVo.PostToVO;
import com.msyq.psetshop.PoToVo.UsersToVO;
import com.msyq.psetshop.service.PhotosService;
import com.msyq.psetshop.service.PostService;
import com.msyq.psetshop.service.UsersService;
import com.msyq.psetshop.utils.date.DateTimeUtils;
import com.msyq.psetshop.vo.PhotosVO;
import com.msyq.psetshop.vo.PostVO;
import com.msyq.psetshop.vo.UsersVO;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

@Component
public class PhotoCollectToVOQ {

    public static PhotoCollectToVOQ photoCollectToVOQ;

    @Autowired
    private UsersService usersService;

    @Autowired
    private PhotosService photosService;

    @PostConstruct
    public void init(){
        photoCollectToVOQ = this;
        photoCollectToVOQ.usersService = this.usersService;
        photoCollectToVOQ.photosService = this.photosService;
    }

    @Named("fkUId")
    public UsersVO fkUId(Integer integer){
        if (integer == null){
            return null;
        }
        return UsersToVO.usersToVO.usersVO(photoCollectToVOQ.usersService.selectByPrimaryKey(integer));
    }

    @Named("fkPgId")
    public PhotosVO fkPgId(Integer integer){
        if (integer == null){
            return  null;
        }
        return PhotosToVO.photosToVO.photosVo(photoCollectToVOQ.photosService.selectByPrimaryKey(integer));
    }

    @Named("dateToStr")
    public String dateToStr(Date date){
        if (date == null){
            return null;
        }
        return DateTimeUtils.DATE_TIME.formatDate(date);
    }

}
