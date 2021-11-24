package com.msyq.psetshop.Module.individual;

import java.io.Serializable;

public enum EmoudleData implements EmoudleDataInterface {

    MODULE_A("Reservation","就诊管理","预约管理",
            "预约管理"),
    MODULE_B("Reservation","就诊管理","预约管理",
            "预约管理"),
    MODULE_C("Posts", "帖子信息", "最新发布",
            "最新发布"),
     ;
//    模块
    private String reservation;
//    模块名
    private String moduleName;
//  标签
    private String display;
//    数据名
    private String namea ;


    EmoudleData(String reservation, String moduleName, String display, String namea) {
        this.reservation = reservation;
        this.moduleName = moduleName;
        this.display = display;
        this.namea = namea;
    }


    @Override
    public String reservation() {
        return reservation;
    }

    @Override
    public String moduleName() {
        return moduleName;
    }

    @Override
    public String display() {
        return display;
    }

    @Override
    public String namea() {
        return namea;
    }


}
