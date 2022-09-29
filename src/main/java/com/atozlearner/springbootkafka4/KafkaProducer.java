package com.atozlearner.springbootkafka4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    private static final String TOPIC = "test_topic";

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public String writeMessage(String message){

        this.kafkaTemplate.send(TOPIC,message);

        return "Message sent to kafka Topic test_topic Successfully";
    }
}
