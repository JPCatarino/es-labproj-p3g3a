package com.l3a.coinRanking.kafka;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Adapted from https://dzone.com/articles/magic-of-kafka-with-spring-boot
 */
@Service
public class Consumer {

    private final Logger logger = LoggerFactory.getLogger(Consumer.class);
    private List<String> consumedMessages = new ArrayList<>();

    @KafkaListener(topics = "users", groupId = "coinranking")
    public void consume(String message){
        logger.info(String.format("$$ -> Consumed Message -> %s",message));
        consumedMessages.add(message);
    }

    @KafkaListener(topics = "system", groupId = "coinranking")
    public void consumeSystem(String message){
        consumedMessages.add(message);
    }

    @KafkaListener(topics = "logs", groupId = "coinranking")
    public void consumeLogs(String message){
        consumedMessages.add(message);
    }

    public List<String> getConsumedMessages(){
        return this.consumedMessages;
    }

}
