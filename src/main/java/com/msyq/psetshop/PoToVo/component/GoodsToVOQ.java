package com.msyq.psetshop.PoToVo.component;

import com.msyq.psetshop.pojo.GoodsCategory;
import com.msyq.psetshop.pojo.Type;
import com.msyq.psetshop.service.GoodsCategoryService;
import com.msyq.psetshop.service.TypeService;
import com.msyq.psetshop.utils.date.DateTimeUtils;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class GoodsToVOQ {

    @Autowired
    private GoodsCategoryService goodsCategoryService;
    @Autowired
    private TypeService typeService;

    public static GoodsToVOQ goodsToVOQ;

    @PostConstruct
    public void init() {
        goodsToVOQ = this;
        goodsToVOQ.goodsCategoryService = this.goodsCategoryService;
        goodsToVOQ.typeService = this.typeService;
    }

    @Named("dateToStr")
    public String dateToStr(Date date) {
        if (date == null) {
            return null;
        }
        return DateTimeUtils.DATE.formatDate(date);
    }

    @Named("fkGcId")
    public List<GoodsCategory> goodsCategory(String str) {
        if (str != null) {
            String[] strings = str.split("-");
            List<GoodsCategory> goodsCategories = new ArrayList<>();

            for (String gc : strings) {
                if (!gc.equals(null)) {
                    goodsCategories.add(goodsToVOQ.goodsCategoryService.selectByPrimaryKey(Integer.parseInt(gc)));
                }
            }
            return goodsCategories;
        }
        return null;
    }

    @Named("fkTypeId")
    public List<Type> types(String str) {
        if (str != null) {
            String[] strings = str.split("-");
            List<Type> goodsCategories = new ArrayList<>();

            for (String gc : strings) {
                if (!gc.equals(null)) {
                    goodsCategories.add(goodsToVOQ.typeService.selectByPrimaryKey(Integer.parseInt(gc)));
                }
            }

            return goodsCategories;
        }
        return null;
    }

    @Named("gImgs")
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

}
