package com.msyq.psetshop.Module.individual;

import lombok.Data;

import java.util.List;

@Data
public class ModuleData {

    private String module;

    private String moduleName;

    private String display;

    private List<ModuleDataData> moduleData;

}
