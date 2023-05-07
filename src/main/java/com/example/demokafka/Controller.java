package com.example.demokafka;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final KafkaTemplate<String, CustomMessage> kafkaTemplate;
    @Value("${kafka.topic}")
    private String topic;
    @PostMapping("/message")
    public void sendMessage(@RequestBody CustomMessage customMessage) {
        kafkaTemplate.send(topic, customMessage);
    }
}
