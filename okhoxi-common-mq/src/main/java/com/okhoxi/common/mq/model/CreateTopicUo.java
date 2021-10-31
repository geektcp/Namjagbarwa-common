package com.okhoxi.common.mq.model;

import lombok.Data;

/**
 * @author Mr.Tang
 * @date 2021/9/15 13:47
 */
@Data
public class CreateTopicUo {

    /**
     * 主题名称
     */
    private String name;

    /**
     * 分区数量
     */
    private int paratitionCount;

    /**
     * 副本数量
     */
    private Short replicationFactor;
}
