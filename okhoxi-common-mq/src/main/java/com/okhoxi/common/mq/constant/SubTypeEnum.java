package com.okhoxi.common.mq.constant;

/**
 * 用户消息信息分类
 * @author Mr.Tang
 * @date 2021/10/19 14:12
 */
public enum SubTypeEnum {

    NOT_PAY("NOT_PAY", "待支付"),
    SUCCESS_PAY("SUCCESS_PAY", "支付成功"),
    FAILED_PAY("FAILED_PAY", "支付异常"),

    ;

    private String code;
    private String desc;

    SubTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}

