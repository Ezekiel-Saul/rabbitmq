package com.zql.rabbitmq.publisher;

import com.zql.rabbitmq.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JsonRabbitMQProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.json.routing.key}")
    private String jsonRoutingKey;

    private RabbitTemplate template;
    private final static Logger LOGGER = LoggerFactory.getLogger(JsonRabbitMQProducer.class);

    public JsonRabbitMQProducer(RabbitTemplate template) {
        this.template = template;
    }

    public void sendJsonMessage(User user){
        LOGGER.info(String.format("JSON Message sent -> %s", user.toString()));
        template.convertAndSend(exchange,jsonRoutingKey, user);
    }
}
