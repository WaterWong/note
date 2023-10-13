package org.open.lang.ms.note.api.module;

import org.soul.base.ienums.IErrorCode;
import org.soul.base.lang.string.StringTool;

import java.text.MessageFormat;

/**
 * @author Roger
 */
public enum CommonErrorCodeEnum implements IErrorCode {

    DATA_EXIST( "D-100", "Data is Exist"),
        ;

    private String code;
    private String message;

    CommonErrorCodeEnum(String code, String message) {
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
    public String getMessage(Object... objects) {
        if (StringTool.isBlank(message)) {
            return "";
        }
        return MessageFormat.format(message,objects);
    }
}
