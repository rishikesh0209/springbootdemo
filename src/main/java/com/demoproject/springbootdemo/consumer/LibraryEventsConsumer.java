package com.demoproject.springbootdemo.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

// @Component  //disabled to use manual offset 
@Slf4j
public class LibraryEventsConsumer {
    
    @KafkaListener(topics = "library-events") //uses concurrentMessageListener container 
    public void onMessage(ConsumerRecord<Integer,String> consumerRecord){
        log.info("ConsumerRecords: "+consumerRecord);
    }
}
