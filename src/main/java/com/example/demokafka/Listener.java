package com.example.demokafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Listener {

    @KafkaListener(id = "myId", topics = "my-topic")
    public void consumeMessage(CustomMessage customMessage) {
        log.info("Message {} consumed", customMessage);
    }
}

