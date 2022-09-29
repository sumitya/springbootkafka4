package com.atozlearner.springbootkafka4.controller;


import com.atozlearner.springbootkafka4.KafkaProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka-spring/")
public class KafkaController {

    private final KafkaProducer kafkaProducer;
    public KafkaController(KafkaProducer producer){ this.kafkaProducer = producer; }
    
    @GetMapping(value = "/send")
    public String writeMessageToTopic(@RequestParam("message") String message){
        System.out.println("In a writeMessageToTopic");
        this.kafkaProducer.writeMessage(message);

        return "Message sent to Kafka TOPIC test_topic";
    }
}
