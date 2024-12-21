package com.zql.rabbitmq.consumer;

import com.zql.rabbitmq.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class JsonRabbitmqConsumer {

    private final static Logger LOGGER = LoggerFactory.getLogger(JsonRabbitmqConsumer.class);

    @RabbitListener(queues = "${rabbitmq.queue.json.name}")
    public void consume(User user){
        LOGGER.info(String.format("Message Json received -> %s", user.toString()));
    }


}
