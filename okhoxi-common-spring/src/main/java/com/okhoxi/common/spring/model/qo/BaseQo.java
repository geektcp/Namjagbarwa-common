package com.okhoxi.common.spring.model.qo;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Mr.Tang on 2021/1/16.
 */
@Data
public class BaseQo {
    public static final String OPTION_DEBUG = "option_debug";
    public static final String OPTION_TIMEOUT = "option_timeout";

    @ApiModelProperty(value = "内部可选参数")
    private JSONObject internalOption = new JSONObject();

    public boolean isDebug() {
        return internalOption.getBooleanValue(OPTION_DEBUG);
    }

    public void setDebug(boolean debugEnabled) {
        this.internalOption.put(OPTION_DEBUG, debugEnabled);
    }
}
