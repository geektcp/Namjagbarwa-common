package com.okhoxi.common.spring.model.vo;

import java.io.Serializable;

public class BaseResponseVO<T> implements Serializable {
    private static final long serialVersionUID = -2967383587947830027L;
    Integer code;
    String msg;
    T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
