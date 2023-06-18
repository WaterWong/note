package org.open.lang.ms.note.api.consts;

import org.soul.base.ienums.IErrorCode;

import java.text.MessageFormat;

public enum CodeEnum implements IErrorCode {

    USER_EXIST("10001","user exists"),
    USER_NOT_EXIST("10002","user not exists"),

    MY_AVATAR_FAIL("20001","avator upload fail"),


    ;

    private String code;
    private String message;

    CodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getMessage(Object... params) {
        return MessageFormat.format(message,params);
    }
}
