package com.okhoxi.common.spring.model.vo;

import lombok.Data;

/**
 * @author Mr.Tang
 * @date 2019/9/9 14:14
 **/
@Data
public class HttpContextInfo {
    private String tenantId;
    private String hostIp;
    private String userName;
    private Integer userId;
    private Integer userType;
}
