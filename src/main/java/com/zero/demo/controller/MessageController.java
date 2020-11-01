package com.zero.demo.controller;

import com.zero.demo.common.config.kafka.common.CommonMessage;
import com.zero.demo.common.util.ObjectMapperUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author zero
 * @created on 2020-04-24
 */
@RestController
@RequestMapping("/message")
@Slf4j
public class MessageController {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @PostMapping("/send")
    public void sendMessageg(@RequestBody String message) throws Exception  {
        CommonMessage commonMessage =
                CommonMessage.builder()
                        .from("test")
                        .message(message)
                        .build();
        log.info("commonMessage={}", ObjectMapperUtils.toJSON(commonMessage));
        kafkaTemplate.send("test", ObjectMapperUtils.toJSON(commonMessage)).get(3, TimeUnit.SECONDS);
    }
}
