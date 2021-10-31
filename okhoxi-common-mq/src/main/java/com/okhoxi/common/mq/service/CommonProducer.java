package com.okhoxi.common.mq.service;

import com.okhoxi.common.mq.model.MessageDTO;

/**
 * @author Mr.Tang on 2021/9/13 11:09.
 *
 * 消息推送
 */
public interface CommonProducer {

    /**
     * 单独推送消息，同步
     * */
    Boolean syncSend(MessageDTO<?> msg);

    /**
     * 单独推送消息, 异步
     * */
    Boolean asyncSend(MessageDTO<?> msg);

    /**
    * 批量推送消息
    * */
    Boolean bulkSend(MessageDTO<?> msg);

}
