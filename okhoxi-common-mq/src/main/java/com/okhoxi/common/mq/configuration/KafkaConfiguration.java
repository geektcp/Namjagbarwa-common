package com.okhoxi.common.mq.configuration;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.KafkaAdminClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.listener.ConsumerAwareListenerErrorHandler;

import java.util.Properties;

/**
 * kafka 配置中心
 * @author Mr.Tang
 * @date 2021/9/15 9:47
 */
@Slf4j
@Data
@Configuration
public class KafkaConfiguration {

    @Value("${spring.kafka.bootstrap-servers}")
    private String server;

    @Bean
    public KafkaAdminClient kafkaAdminClient(){
        Properties props = new Properties();
        props.put("bootstrap.servers", server);
        return (KafkaAdminClient) KafkaAdminClient.create(props);
    }

    @Bean
    public ConsumerAwareListenerErrorHandler consumerAwareErrorHandler() {
        return (message, exception, consumer) -> {
            log.error("消费异常, {}", message.getPayload());
            log.error("消费异常", exception);
            return null;
        };

    }
}
