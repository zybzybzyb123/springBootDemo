package com.zero.demo.common.config.kafka.consumer;

import com.zero.demo.common.config.kafka.common.CommonMessage;
import com.zero.demo.common.util.ObjectMapperUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author zero
 * @created on 2020/4/23
 */
@Service
@Slf4j
@ConditionalOnProperty("spring-kafka-enable")
public class KafkaMessageConsumer {


    @KafkaListener(topics = "test", groupId = "defaultGroup")
    public void processMessage(String json) {
        CommonMessage commonMessage = ObjectMapperUtils.fromJSON(json, CommonMessage.class);
        log.info("consume message {}", commonMessage);
    }
}