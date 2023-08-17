package com.example.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import javax.annotation.Resource;

@Component
public class KafkaMessageProducer {
    private static final Logger logger = LoggerFactory.getLogger(KafkaMessageProducer.class);
    @Resource
    private KafkaTemplate<String, String> kafkaTemplate; // 装配Kafka模板Bean
    @Value("${kafka.topic.test}") // 读取配置文件中Topic的设置
    public String topic;
    public void send(String stuid,String couid) {
//        String message = "Hello World -6.18--" + System.currentTimeMillis();
        String message = "res: "+stuid+" chosen: "+couid;
        // 向kafka发送消息
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(this.topic, message);
        // 设置成功与失败的回调方法
        future.addCallback(success -> logger.info("KafkaMessageProducer 发送消息成功！"),
                fail -> logger.error("KafkaMessageProducer 发送消息失败！"));
    }
}
