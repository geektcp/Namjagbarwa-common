package com.okhoxi.common.mq.model;

import lombok.Data;

/**
 * @author Mr.Tang
 * @date 2021/9/15 9:35
 */
@Data
public class TopicVo {

    /**
     * 主题名称
     */
    private String name;

    /**
     * 分区数量
     */
    private Integer partitions;


}
