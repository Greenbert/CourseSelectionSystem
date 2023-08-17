package com.example.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageConsumer {
    private static final Logger logger = LoggerFactory.getLogger(KafkaMessageConsumer.class);
    @KafkaListener(topics = {"${kafka.topic.test}"})
    public void receive(@Payload String message, @Headers MessageHeaders headers){
        logger.info("KafkaMessageConsumer 接收到消息：" + message);
        headers.keySet().forEach(key->logger.info("{}: {}",key,headers.get(key)));
    }
}
