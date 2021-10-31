package com.okhoxi.common.spring.constant;


import com.okhoxi.common.core.constant.Status;

public enum ProgressStatus implements Status {

    COMPLETED(0, "完成"),
    PROCESSING(1, "进行中"),
    FAILED(2, "失败");

    private int code;
    private String desc;

    ProgressStatus(Integer code, String desc) {
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
