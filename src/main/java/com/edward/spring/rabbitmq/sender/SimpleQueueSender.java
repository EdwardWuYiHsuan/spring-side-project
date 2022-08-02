package com.edward.spring.rabbitmq.sender;

import com.edward.spring.config.RabbitMqConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SimpleQueueSender {

    private final AmqpTemplate rabbitTemplate;

    public void sendMessageToQueue(String message) {
        rabbitTemplate.convertAndSend(RabbitMqConfig.FANOUT_NAME_TEST, "", message);
    }
}
