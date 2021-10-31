package com.okhoxi.common.core.constant;

/**
 *
 * 共用 错误码
 * @author Mr.Tang
 * @date 2021/7/15 14:30
 */
public enum CommonExceptionStatus implements Status {

    SYSTEM_BUSY(-1, "系统繁忙~请稍后再试~"),
    SYSTEM_TIMEOUT(-2, "系统维护中~请稍后再试~"),
    PARAM_EX(-3, "参数类型解析异常"),
    SQL_EX(-4, "运行SQL出现异常"),
    NULL_POINT_EX(-5, "空指针异常"),
    ILLEGALA_ARGUMENT_EX(-6, "无效参数异常"),
    MEDIA_TYPE_EX(-7, "请求类型异常"),
    LOAD_RESOURCES_ERROR(-8, "加载资源出错"),
    BASE_VALID_PARAM(-9, "统一验证参数异常"),
    OPERATION_EX(-10, "操作异常"),
    SERVICE_MAPPER_ERROR(-11, "Mapper类转换异常"),
    CAPTCHA_ERROR(-12, "验证码校验失败"),
    JSON_PARSE_ERROR(-13, "JSON解析异常"),
    REQUEST_RETURN_NULL(-14, "请求返回为空"),
    BAD_REQUEST(400, "错误的请求"),
    UNAUTHORIZED(401, "未经授权"),
    NOT_FOUND(404, "没有找到资源"),
    METHOD_NOT_ALLOWED(405, "不支持当前请求类型"),
    TOO_MANY_REQUESTS(429, "请求超过次数限制"),
    INTERNAL_SERVER_ERROR(500, "内部服务错误"),
    BAD_GATEWAY(502, "网关错误"),
    GATEWAY_TIMEOUT(504, "网关超时"),
    REQUIRED_FILE_PARAM_EX(1001, "请求中必须至少包含一个有效文件"),
    DATA_SAVE_ERROR(2000, "新增数据失败"),
    DATA_UPDATE_ERROR(2001, "修改数据失败"),
    TOO_MUCH_DATA_ERROR(2002, "批量新增数据过多"),
    JWT_BASIC_INVALID(4000, "无效的基本身份验证令牌"),
    JWT_TOKEN_EXPIRED(4001, "会话超时，请重新登录"),
    JWT_SIGNATURE(4002, "不合法的token，请认真比对 token 的签名"),
    JWT_ILLEGAL_ARGUMENT(4003, "缺少token参数"),
    JWT_GEN_TOKEN_FAIL(4004, "生成token失败"),
    JWT_PARSER_TOKEN_FAIL(4005, "解析用户身份错误，请重新登录！"),
    JWT_USER_INVALID(4006, "用户名或密码错误"),
    JWT_USER_ENABLED(4007, "用户已经被禁用！"),
    JWT_OFFLINE(4008, "您已在另一个设备登录！"),
    UPLOAD_FILE_TYPE_ERROR(4009, "上传的文件类型不在允许范围内，请检查"),
    UPLOAD_FILE_ERROR(4010, "保存文件失败，请刷新页面重试或联系系统管理员"),

    ERROR_LOG_INSERT(5000, "记录操作日志时发生错误！"),

    ;


    private int code;
    private String desc;

    CommonExceptionStatus(Integer code, String desc) {
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
