package com.l3a.coinRanking.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Adapted from https://dzone.com/articles/magic-of-kafka-with-spring-boot
 */

@Service
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(String message, String topic){
        logger.info(String.format("$$ -> Producing message --> %s",message));
        this.kafkaTemplate.send(topic,message);
    }

}
