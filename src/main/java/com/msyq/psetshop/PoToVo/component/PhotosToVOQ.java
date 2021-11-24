package com.msyq.psetshop.PoToVo.component;

import com.msyq.psetshop.PoToVo.PhotoCollectToVO;
import com.msyq.psetshop.PoToVo.UsersToVO;
import com.msyq.psetshop.pojo.PhotosGlance;
import com.msyq.psetshop.pojo.Type;
import com.msyq.psetshop.service.PhotoCollectService;
import com.msyq.psetshop.service.PhotosGlanceService;
import com.msyq.psetshop.service.TypeService;
import com.msyq.psetshop.service.UsersService;
import com.msyq.psetshop.utils.date.DateTimeUtils;
import com.msyq.psetshop.vo.PhotoCollectVO;
import com.msyq.psetshop.vo.UsersVO;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class PhotosToVOQ {

    public static PhotosToVOQ photosToVOQ;

    @Autowired
    private PhotosGlanceService photosGlanceService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private PhotoCollectService photoCollectService;

    @PostConstruct
    public void init(){
        photosToVOQ = this;
        photosToVOQ.photosGlanceService = this.photosGlanceService;
        photosToVOQ.usersService = this.usersService;
        photosToVOQ.typeService = this.typeService;
        photosToVOQ.photoCollectService = this.photoCollectService;
    }

//    @Named("pId")
//    public PhotosGlance pId(Integer integer){
//        if (integer == null){
//            return null;
//        }
//        PhotosGlance photosGlance = new PhotosGlance();
//        PhotosGlance photosGlance1 = photosToVOQ.photosGlanceService.selectByPrimaryKey(integer);
//        if (photosGlance1 == null){
//            photosGlance.setFkPId(integer);
//            photosGlance.setPgTf(0);
//        }else photosGlance=photosGlance1;
//        return photosGlance;
//    }

    @Named("pType")
    public List<Type> types(String str) {
        if (str != null) {
            String[] strings = str.split("-");
            List<Type> typeCategories = new ArrayList<>();

            for (String gc : strings) {
                if (!gc.equals(null)) {
                    typeCategories.add(photosToVOQ.typeService.selectByPrimaryKey(Integer.valueOf(gc)));
                }
            }

            return typeCategories;
        }
        return null;
    }

    @Named("pConent")
    public List<String> gImgs(String str) {
        if (str != null) {
            String[] strings = str.split("&");
            List<String> goodsCategories = new ArrayList<>();

            for (String gc : strings) {
                if (!gc.equals(null)) {
                    goodsCategories.add(gc);
                }
            }

            return goodsCategories;
        }
        return null;
    }

    @Named("fkUId")
    public UsersVO fkUId(Integer integer){
        if (integer == null){
            return null;
        }
        return UsersToVO.usersToVO.usersVO(photosToVOQ.usersService.selectByPrimaryKey(integer));
    }

    @Named("dateToStr")
    public String dateToStr(Date date){
        if (date == null){
            return null;
        }
        return DateTimeUtils.DATE.formatDate(date);
    }
}
