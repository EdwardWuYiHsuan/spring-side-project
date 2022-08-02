package com.edward.spring.rabbitmq.consumer;

import com.edward.spring.config.RabbitMqConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SimpleQueueConsumer {

    @RabbitListener(queues = RabbitMqConfig.QUEUE_NAME_TEST)
    public void simpleQueueConsumer(String in) {
        System.out.println("Message read from Queue' : " + in);
    }
}
