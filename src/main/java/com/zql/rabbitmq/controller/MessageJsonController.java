package com.zql.rabbitmq.controller;

import com.zql.rabbitmq.dto.User;
import com.zql.rabbitmq.publisher.JsonRabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageJsonController {

    private JsonRabbitMQProducer producer;

    public MessageJsonController(JsonRabbitMQProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> getJsonMessage(@RequestBody User user){
         producer.sendJsonMessage(user);
         return ResponseEntity.ok("Json message sent to RabbitMQ...");
    }
}
