package com.okhoxi.common.spring.model.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.okhoxi.common.core.constant.Status;
import com.okhoxi.common.core.exception.BaseException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Mr.Tang on 2018/5/2.
 */
@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "接口响应数据", description = "用于返回接口响应的内容")
public class ResponseDTO<T> {

    @JSONField(ordinal = 1)
    @ApiModelProperty(value = "请求响应代码")
    private Object code = 200;

    @JSONField(ordinal = 2)
    @ApiModelProperty(value = "描述信息")
    private Object msg;

    @JSONField(ordinal = 3)
    @ApiModelProperty(value = "请求是否成功：true（成功）；false（失败）", example = "true")
    private boolean success = true;

    @ApiModelProperty(value = "数据内容")
    @JSONField(ordinal = 4)
    private T data;

    @JSONField(ordinal = 5)
    @ApiModelProperty(value = "详细描述信息")
    private Object subMsg;

    public ResponseDTO() {
        this(null);
    }

    public ResponseDTO(T data) {
        this.setData(data);
    }

    public static <T> ResponseDTO<T> success() {
        return new ResponseDTO<>();
    }

    public static <T> ResponseDTO<T> success(T data) {
        return new ResponseDTO<>(data);
    }

    public static <T> ResponseDTO<T> error() {
        ResponseDTO<T> responseDTO = new ResponseDTO<>();
        responseDTO.setSuccess(false);
        return responseDTO;
    }

    public static <T> ResponseDTO<T> error(String msg) {
        ResponseDTO<T> responseDTO = new ResponseDTO<>();
        responseDTO.setSuccess(false);
        responseDTO.setMsg(msg);
        return responseDTO;
    }

    public static <T> ResponseDTO<T> error(int code, String msg) {
        ResponseDTO<T> responseDTO = new ResponseDTO<>();
        responseDTO.setSuccess(false);
        responseDTO.setCode(code);
        responseDTO.setMsg(msg);
        return responseDTO;
    }

    public static <T> ResponseDTO<T> error(int code, String msg, String subMsg) {
        ResponseDTO<T> responseDTO = new ResponseDTO<>();
        responseDTO.setSuccess(false);
        responseDTO.setCode(code);
        responseDTO.setMsg(msg);
        responseDTO.setSubMsg(subMsg);
        return responseDTO;
    }

    public static <T> ResponseDTO<T> error(BaseException ex) {
        ResponseDTO<T> responseDTO = new ResponseDTO<>();
        responseDTO.setSuccess(false);
        responseDTO.setMsg(buildMessage(ex));
        return responseDTO;
    }

    public static <T> ResponseDTO<T> error(Status status) {
        ResponseDTO<T> responseDTO = new ResponseDTO<>();
        responseDTO.setSuccess(false);
        responseDTO.setMsg(buildMessage(status));
        return responseDTO;
    }

    public static <T> ResponseDTO<T> error(Status status, Object... args) {
        ResponseDTO<T> responseDTO = new ResponseDTO<>();
        responseDTO.setSuccess(false);
        responseDTO.setMsg(buildMessage(status, args));
        return responseDTO;
    }

    private static Map<String, Object> buildMessage(BaseException ex) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("code", ex.getCode());
        map.put("desc", ex.getDesc());
        return map;
    }

    private static Map<String, Object> buildMessage(Status status) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("code", status.getCode());
        map.put("desc", status.getDesc());
        return map;
    }

    private static Map<String, Object> buildMessage(Status status, Object... args) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("code", status.getCode());
        map.put("desc", format(status.getDesc(), args));
        return map;
    }

    private static String format(String pattern, Object... arguments) {
        return MessageFormat.format(pattern, arguments);
    }

    public ResponseDTO<T> setErrorInfo(Status status) {
        this.setMsg(status);
        return this;
    }

    public ResponseDTO<T> setData(T data) {
        this.data = data;
        return this;
    }

}
