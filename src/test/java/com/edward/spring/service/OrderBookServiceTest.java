package com.edward.spring.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class OrderBookServiceTest {

    @Autowired
    private OrderBookService orderBookService;

    @Test
    public void testOrder() {
        assertThat(orderBookService).isNotNull();
        int result = orderBookService.order();
        assertThat(result).isEqualTo(3);
    }
}
