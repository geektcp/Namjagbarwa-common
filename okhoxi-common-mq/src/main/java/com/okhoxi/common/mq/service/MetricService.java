package com.okhoxi.common.mq.service;

/**
 * @author Mr.Tang on 2021/9/13 13:38.
 *
 * 集群健康状态产讯
 *
 */
public interface MetricService {


    /**
     * 获取消息生产的统计，埋点标记
     * 统计每个topic生产了多少条消息记录
     * 和消费端进行对比，是否丢失消息
     * */
    void getMqMetric();



}
