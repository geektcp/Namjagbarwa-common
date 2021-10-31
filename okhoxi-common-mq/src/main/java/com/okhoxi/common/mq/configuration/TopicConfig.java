package com.okhoxi.common.mq.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Mr.Tang
 * @date 2021/9/23 15:38
 */
@Component
public class TopicConfig {

    @Value("${pay.notify.topic:topic.core.pay.notify}")
    public String payNotifyTopic;

    @Value("${auth.info.topic:topic.base.auth.info}")
    public String authInfoTopic;

    @Value("${graph.data.topic:topic.core.graph.data}")
    public String graphDataTopic;

    @Value("${design.diagram.topic:topic.design.design.diagram}")
    public String designDiagramTopic;

    @Value("${log.operate.topic:topic.base.log.operate}")
    public String logOperateTopic;

    @Value("${auth.resource.topic:topic.base.auth.resource}")
    public String authResourceTopic;

}
