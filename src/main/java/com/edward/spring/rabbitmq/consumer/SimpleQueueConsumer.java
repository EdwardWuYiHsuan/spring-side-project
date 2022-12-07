package com.edward.spring.rabbitmq.consumer;

import com.edward.spring.configuration.RabbitMqConfiguration;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SimpleQueueConsumer {

    @RabbitListener(queues = RabbitMqConfiguration.QUEUE_NAME_TEST)
    public void simpleQueueConsumer(String in) {
        System.out.println("Message read from Queue' : " + in);
    }
}
