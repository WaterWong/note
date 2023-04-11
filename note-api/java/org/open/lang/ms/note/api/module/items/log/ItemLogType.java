package org.open.lang.ms.note.api.module.items.log;

import org.soul.base.ienums.ICodeEnum;

public enum ItemLogType implements ICodeEnum {
    EDIT("EDIT","编辑"),
    VIEW("VIEW","查看"),
    WRITE("WRITE","编辑"),
    ;

    private String code;
    private String trans;

    ItemLogType(String code, String trans) {
        this.code = code;
        this.trans = trans;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getTrans() {
        return trans;
    }
}
