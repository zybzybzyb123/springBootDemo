package com.zero.demo.common.config.kafka.common;

import com.google.common.collect.ImmutableMap;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.Map;

/**
 * @author zero
 * @created on 2020/4/23
 */
@EnableKafka
@Configuration
public class KafkaConsumerConfig {
 
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    private String consumerGroupId = "testGroup";

    private String autoOffsetReset = "latest";
 
    @Bean
    public ConsumerFactory<String, Object> consumerFactory() {
        Map<String, Object> props =
                ImmutableMap.<String, Object> builder()
                        .put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                                bootstrapServers)
                        .put(ConsumerConfig.GROUP_ID_CONFIG, consumerGroupId)
                        .put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,
                                autoOffsetReset)
                        .build();
        return new DefaultKafkaConsumerFactory (
                props,
                new StringDeserializer(),
                new StringDeserializer());
    }
 
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory
                = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}