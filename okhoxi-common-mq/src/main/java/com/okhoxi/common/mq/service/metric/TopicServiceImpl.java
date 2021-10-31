package com.okhoxi.common.mq.service.metric;

import cn.hutool.core.collection.CollectionUtil;
import com.okhoxi.common.mq.model.CreateTopicUo;
import com.okhoxi.common.mq.model.TopicVo;
import com.okhoxi.common.mq.service.TopicService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.DeleteTopicsResult;
import org.apache.kafka.clients.admin.DescribeTopicsResult;
import org.apache.kafka.clients.admin.KafkaAdminClient;
import org.apache.kafka.clients.admin.ListTopicsOptions;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.admin.TopicDescription;
import org.apache.kafka.common.KafkaFuture;
import org.apache.kafka.common.TopicPartition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/**
 * @author Mr.Tang on 2021/9/13 13:39.
 */
@Service
@Slf4j
public class TopicServiceImpl implements TopicService {

    /**
     *
     */
    @Autowired
    private KafkaAdminClient kafkaAdminClient;

    @Autowired
    private KafkaListenerEndpointRegistry registry;

    /**
     * 主题列表
     * @return  主题列表记录
     */
    @Override
    public List<TopicVo> list() throws ExecutionException, InterruptedException {
        List<TopicVo> list = new ArrayList<>();
        Set<String> topics = listTopicToSet();
        DescribeTopicsResult describeTopicsResult = kafkaAdminClient.describeTopics(topics);
        KafkaFuture<Map<String, TopicDescription>> mapKafkaFuture = describeTopicsResult.all();
        Map<String, TopicDescription> map = mapKafkaFuture.get();
        topics.forEach(name ->{
            TopicVo topicVo = new TopicVo();
            topicVo.setName(name);
            TopicDescription topicDescription = map.get(name);
            if(topicDescription != null){
                topicVo.setPartitions(topicDescription.partitions().size());
            }
            list.add(topicVo);
        });
        kafkaAdminClient.close();
       return list;
    }

    /**
     * 新增 主题
     * @param uo 新增主题
     * @return true 成功 |false 失败
     */
    @Override
    public boolean createTopic(CreateTopicUo uo){
        String name = uo.getName();
        if(StringUtils.isBlank(name)){
            log.error("请求参数name为空");
            return false;
        }
        Set<String> topicSet = null;
        try {
            topicSet = listTopicToSet();
        } catch (InterruptedException e) {
            log.error("查询topic异常" ,e);
            return false;
        } catch (ExecutionException e) {
            log.error("查询topic异常" ,e);
            return false;
        }
        if(topicSet.contains(name)){
            log.error("已存在topic={}", name);
            return false;
        }
        int paratition = uo.getParatitionCount();
        if(paratition <= 0){
            paratition = 1;
        }
        Short replicationFactor = uo.getReplicationFactor();
        if(replicationFactor == null || replicationFactor <= 0){
            replicationFactor = (short) 1;
        }
        NewTopic topic = new NewTopic(name,paratition, replicationFactor);
        CreateTopicsResult createTopicsResult = kafkaAdminClient.createTopics(Arrays.asList(topic));
        boolean flag = false;
        try {
            KafkaFuture<Void> future = createTopicsResult.all();
            future.get();
            // 如果future 是异常  future.isCompletedExceptionally() = true
            flag = !future.isCompletedExceptionally();
        }catch (Exception e){
            log.error("创建topic，获取结果异常", e);
            return false;
        }
        kafkaAdminClient.close();
        return flag;
    }

    /**
     * 删除 分区
     * @param name 主题名称
     * @return true 删除成功
     */
    @Override
    public boolean deleteTopic(String name) {
        List<String> topicNames = Arrays.asList(name);
        Set<String> topicSet = null;
        try {
            topicSet = listTopicToSet();
        } catch (InterruptedException e) {
            log.error("查询topic异常" ,e);
            return false;
        } catch (ExecutionException e) {
            log.error("查询topic异常" ,e);
            return false;
        }
        if(!topicSet.contains(name)){
            log.error("不存在topic={}", name);
            return false;
        }
        DeleteTopicsResult result = kafkaAdminClient.deleteTopics(topicNames);
        KafkaFuture<Void> future = result.all();
        boolean flag = false;
        try {
            future.get();
            flag = !future.isCompletedExceptionally();
        } catch (InterruptedException e) {
            log.error("删除topic异常", e);
            return false;
        } catch (ExecutionException e) {
            log.error("删除topic异常", e);
            return false;
        }
        if(!flag){
            log.error("删除topic失败");
            return flag;
        }
        List<MessageListenerContainer> containers = (List<MessageListenerContainer>) registry.getAllListenerContainers();
        if(CollectionUtil.isEmpty(containers)){
            log.error("没有获取到监听");
            return true;
        }
        lable : for (MessageListenerContainer container : containers) {
            if(!container.isRunning()){
                continue;
            }
            Collection<TopicPartition> assignedPartitions = container.getAssignedPartitions();
            for (TopicPartition assignedPartition : assignedPartitions) {
                String topic = assignedPartition.topic();
                if(StringUtils.equals(topic, name)){
                    container.stop();
                    break lable;
                }
            }
        }
        return true;
    }


    /**
     * 获取所有主题名称
     * @return 主题名称
     * @throws InterruptedException 异常
     * @throws ExecutionException 异常
     */
    private Set<String> listTopicToSet() throws InterruptedException, ExecutionException {
        ListTopicsOptions listTopicsOptions = new ListTopicsOptions();
        // 不展示 内部topic
        listTopicsOptions.listInternal(false);
        ListTopicsResult result = kafkaAdminClient.listTopics(listTopicsOptions);
        Set<String> topics = result.names().get();
        return topics;
    }




}
