package com.okhoxi.common.mq.service.producer;

import cn.hutool.json.JSONUtil;
import com.okhoxi.common.mq.configuration.TopicConfig;
import com.okhoxi.common.mq.constant.MessageType;
import com.okhoxi.common.mq.model.MessageDTO;
import com.okhoxi.common.mq.service.CommonProducer;
import com.okhoxi.common.mq.service.KafkaProductCountService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * 消息发送
 *
 * @author Mr.Tang on 2021/9/13 11:09.
 */
@Slf4j
@Service
public class CommonProducerImpl implements CommonProducer {

    private static final String SYNC = "SYNC";
    private static final String ASYNC = "SYNC";

    /**
     *
     */
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    private TopicConfig topicConfig;

    @Override
    public Boolean syncSend(MessageDTO<?> dto) {
        boolean validateFlag = validateParam(dto);
        if (!validateFlag) {
            return validateFlag;
        }
        String topic = getTopicByType(dto.getType());
//        Integer partition = dto.getPartition();
        Object data = dto.getData();
//        String key = dto.getKey();
        boolean flag = true;
        try {
            kafkaTemplate.send(topic, data).get();
        } catch (Exception e) {
            log.error("消息发送异常", e);
            log.error("消息发送异常,topic: {}, data={} ", topic, JSONUtil.toJsonStr(data));
            flag = false;
        }
//        send(topic, partition, key, data, SYNC);
        if (flag) {
            KafkaProductCountService.countConcurrentMap(topic);
        }
        return flag;
    }

    @Override
    public Boolean asyncSend(MessageDTO dto) {
        boolean validateFlag = validateParam(dto);
        if (!validateFlag) {
            return validateFlag;
        }
        String topic = getTopicByType(dto.getType());
        if (topic == null) {
            return false;
        }
//        Integer partition = dto.getPartition();
        Object data = dto.getData();
//        String key = dto.getKey();
        boolean flag = kafkaTemplate.executeInTransaction(kt -> {
                kafkaTemplate.send(topic, data);
                return true;
            });
        if (flag) {
            KafkaProductCountService.countConcurrentMap(topic);
        }
        return flag;
    }


    @Override
    public Boolean bulkSend(MessageDTO msg) {
        return false;
    }

    /**
     * 根据类型获取topic
     *
     * @param type 类型
     * @return topic
     */
    private String getTopicByType(MessageType type) {
        if (MessageType.MSG_PAY.equals(type)) {
            return topicConfig.payNotifyTopic;
        }
        if (MessageType.MSG_USER.equals(type)) {
            return topicConfig.authInfoTopic;
        }
        if (MessageType.MSG_ETL.equals(type)) {
            return topicConfig.graphDataTopic;
        }
        if (MessageType.MSG_DIAGRAM.equals(type)) {
            return topicConfig.designDiagramTopic;
        }
        if (MessageType.MSG_OPERATE.equals(type)) {
            return topicConfig.logOperateTopic;
        }
        if (MessageType.MSG_ABILITY.equals(type)) {
            return topicConfig.authResourceTopic;
        }
        log.error("未知消息类型");
        return null;
    }

    /**
     * 校验参数
     *
     * @param dto 参数
     * @return true 校验成功 ，false 校验失败
     */
    private boolean validateParam(MessageDTO dto) {
        if (dto == null) {
            log.error("请求参数为空");
            return false;
        }
        MessageType type = dto.getType();
        if (type == null) {
            log.error("消息类型不能为空");
            return false;
        }
        Object data = dto.getData();
        if (data == null) {
            log.error("消息体不能为空");
            return false;
        }
        String key = dto.getKey();
        Integer partition = dto.getPartition();
        boolean notBlank = StringUtils.isNotBlank(key) && partition != null;
        boolean blank = StringUtils.isBlank(key) && partition == null;
        if (!notBlank && !blank) {
            // key 和partition 必须同时存在， 或同时不存在
            log.error("分区和key必须同时存在，或同时不存在");
            return false;
        }
        log.info("接收到埋点数据={}", JSONUtil.toJsonStr(dto));
        return true;
    }

//    /**
//     * 发送消息到kafka
//     *
//     * @param topic     主题
//     * @param partition 分区
//     * @param key       key
//     * @param data      消息
//     * @param type      1-同步发送 2-异步发送
//     * @return 请求状态 true 成功， false 失败
//     */
//    public boolean send(String topic, Integer partition, String key, Object data, String type) {
//        if (partition != null) {
//            boolean flag = kafkaTemplate.executeInTransaction(kt -> {
//                try {
//                    if (SYNC.equals(type)) {
//                        //  同步
//                        if (data instanceof List) {
//                            // 批量发送
//                            for (Object d : (List<Object>) data) {
//                                kafkaTemplate.send(topic, partition, key, d).get();
//                            }
//                        } else {
//                            kafkaTemplate.send(topic, partition, key, data).get();
//                        }
//                    } else {
//                        // 异步
//                        if (data instanceof List) {
//                            // 批量发送
//                            for (Object d : (List<Object>) data) {
//                                kafkaTemplate.send(topic, partition, key, d);
//                            }
//                        } else {
//                            kafkaTemplate.send(topic, partition, key, data);
//                        }
//                    }
//                } catch (Exception e) {
//                    log.error("消息发送异常", e);
//                    log.error("消息发送异常,topic: {}, partition: {}, key: {}", topic, partition, key);
//                    return false;
//                }
//                return true;
//            });
//            return flag;
//        } else {
//            boolean flag = kafkaTemplate.executeInTransaction(kt -> {
//                try {
//                    if (SYNC.equals(type)) {
//                        //  同步
//                        if (data instanceof List) {
//                            // 批量发送
//                            for (Object d : (List<Object>) data) {
//                                kafkaTemplate.send(topic, d).get();
//                            }
//                        } else {
//                            kafkaTemplate.send(topic, data).get();
//                        }
//                    } else {
//                        // 异步
//                        if (data instanceof List) {
//                            // 批量发送
//                            for (Object d : (List<Object>) data) {
//                                kafkaTemplate.send(topic, d);
//                            }
//                        } else {
//                            kafkaTemplate.send(topic, data);
//                        }
//                    }
//                } catch (Exception e) {
//                    log.error("消息发送异常", e);
//                    log.error("消息发送异常,topic: {}, partition: {}, key: {}", topic, partition, key);
//                    return false;
//                }
//                return true;
//            });
//            return flag;
//        }
//    }

}
