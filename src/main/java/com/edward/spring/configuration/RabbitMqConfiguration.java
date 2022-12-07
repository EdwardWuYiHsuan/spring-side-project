package com.edward.spring.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfiguration {

    public static final String FANOUT_NAME_TEST = "fanout.test";
    public static final String QUEUE_NAME_TEST = "queue.test";

    @Bean(name = "fanoutTest")
    public FanoutExchange fanoutTest() {  //declare fanout.
        return new FanoutExchange(FANOUT_NAME_TEST);
    }

    @Bean(name = "queueTest")
    public Queue queueTest() {  //declare queue channel.
        return new Queue(QUEUE_NAME_TEST, false);
    }

    @Bean
    public Binding bindingExchangeA(@Qualifier("fanoutTest") FanoutExchange fanoutTest, Queue queueTest) {  //bind fanout and queue.
        return BindingBuilder.bind(queueTest).to(fanoutTest);
    }

}
