package com.okhoxi.common.mq.model.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.okhoxi.common.mq.model.MessageVo;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Mr.Tang on 2021/9/13 12:05.
 * <p>
 * 消息实体，运营消息
 */
@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OpsMessageVo implements MessageVo {

    /**
     * 消息标题
     */
    private String title;

    /**
     * 消息内容
     */
    private String body;

}
