package com.okhoxi.common.mq.model.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.okhoxi.common.mq.model.MessageVo;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * @author Mr.Tang on 2021/9/13 12:05.
 * <p>
 * 消息实体，用户个人消息
 */
@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserMessageVo implements MessageVo {

    /**
     * 用户
     */
    private String userId;

    /**
     * 租户
     */
    private String tenantId;

    /**
     * 用户消息信息类型
     */
    private String subType;

    /**
     * 订单号
     */
    private String trandSn;

    /**
     * 各个消息类型自己的参数
     */
    private Map<String, String> aloneParam;

}
