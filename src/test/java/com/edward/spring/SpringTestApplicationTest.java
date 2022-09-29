package com.edward.spring;

import com.edward.spring.service.HelloWorldService;
import com.edward.spring.service.OrderBookService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringTestApplicationTest {

    @Autowired
    private HelloWorldService helloWorldService;
    @Autowired
    private OrderBookService orderBookService;

    @Test
    public void contextLoads() {
        System.out.println("Test Application Context");
        Assertions.assertThat(helloWorldService).isNotNull();
        Assertions.assertThat(orderBookService).isNotNull();
    }
}
