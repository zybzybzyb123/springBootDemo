package com.zero.demo.common.config.kafka.common;

import com.google.common.collect.ImmutableMap;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.Map;

/**
 * @author zero
 * @created on 2020/4/23
 */
@Configuration
public class KafkaProducerConfig<K, V> {
 
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;
 
    @Bean
    public ProducerFactory<K, V> producerFactory() {
        Map<String, Object> configProps =
                ImmutableMap.<String, Object> builder()
                        .put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                                bootstrapServers)
                        .put(ProducerConfig.RETRIES_CONFIG, 0)
                        .put(ProducerConfig.BATCH_SIZE_CONFIG, 4096)
                        .put(ProducerConfig.LINGER_MS_CONFIG, 1)
                        .put(ProducerConfig.BUFFER_MEMORY_CONFIG, 40960)
                        .put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                                StringSerializer.class)
                        .put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                                StringSerializer.class)
                        .build();
        return new DefaultKafkaProducerFactory<>(configProps);
    }
 
    @Bean
    public KafkaTemplate<K, V> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}