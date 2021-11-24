package com.msyq.psetshop.Module.individual;

import lombok.Data;

import java.util.List;

@Data
public class ModuleDataData {

    private String name;

    private String cite;

    private List<ModuleDataDataContent> content;

}
