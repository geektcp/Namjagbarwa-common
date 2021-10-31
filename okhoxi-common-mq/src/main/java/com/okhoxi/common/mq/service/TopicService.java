package com.okhoxi.common.mq.service;

import com.okhoxi.common.mq.model.CreateTopicUo;
import com.okhoxi.common.mq.model.TopicVo;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author Mr.Tang on 2021/9/13 13:38.
 *
 * Topic增删改查
 */
public interface TopicService {


    /**
     * 主题列表
     * @return  主题列表记录
     */
    List<TopicVo> list() throws ExecutionException, InterruptedException;

    /**
     * 新增 主题
     * @param uo 新增主题
     * @return true 成功 |false 失败
     */
    boolean createTopic(CreateTopicUo uo)throws InterruptedException, ExecutionException ;

    /**
     * 删除 分区
     * @param name 主题名称
     * @return true 删除成功
     */
    boolean deleteTopic(String name) throws ExecutionException, InterruptedException ;
}
