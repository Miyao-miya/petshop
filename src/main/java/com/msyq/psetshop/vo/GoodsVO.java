package com.msyq.psetshop.vo;

import com.msyq.psetshop.pojo.GoodsCategory;
import com.msyq.psetshop.pojo.Type;
import lombok.Data;

import java.util.List;

@Data
public class GoodsVO {

    private Integer gId;

    private String gName;

    private List<GoodsCategory> fkGcId;

    private List<Type> fkTypeId;

    private String gContent;

    private Integer gPrice;

    private String gImg;

    private List<String> gImgs;

}
