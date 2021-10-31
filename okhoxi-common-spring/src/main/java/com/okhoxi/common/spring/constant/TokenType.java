package com.okhoxi.common.spring.constant;

import com.okhoxi.common.core.constant.Status;

/**
 * @author Mr.Tang on 2020-03-28 17:41
 */

public enum TokenType implements Status {

    SYS(0, "sys token"),
    AUTH(1, "auth token"),
    ;

    private Integer code;
    private String desc;

    TokenType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getDesc() {
        return desc;
    }
}
