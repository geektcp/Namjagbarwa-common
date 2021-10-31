package com.okhoxi.common.mq.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.okhoxi.common.core.util.IdUtils;
import com.okhoxi.common.mq.constant.MessageType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.codehaus.commons.nullanalysis.NotNull;

/**
 * @author Mr.Tang on 2021/9/13 12:05.
 * <p>
 * 消息实体，所有消息都用该对象包装
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageDTO<T> {

    /**
     * 消息id，全局唯一，id生成器构造得到，必填
     */
    @NotNull
    @JSONField(ordinal = 1)
    private Long id = IdUtils.getId();

    /**
     * 消息类型，微服务构建消息对象时必填
     */
    @NotNull
    @JSONField(ordinal = 2)
    private MessageType type;
    /**
     * 消息内容实体，必填
     */
    @NotNull
    @JSONField(ordinal = 4)
    private T data;


    ///////////////////////////////////////////////////////////
    /**
     * 消息 key  和 分区 partition 必须同时存在，或同时不存在
     */
    @JSONField(ordinal = 5)
    private String key;

    /**
     * 消息分区，选填  消息 key  和 分区 partition 必须同时存在，或同时不存在
     */
    @JSONField(ordinal = 6)
    private Integer partition;

    /**
     * 消息时间戳，选填
     */
    @JSONField(ordinal = 7)
    private Long timestamp;

}
