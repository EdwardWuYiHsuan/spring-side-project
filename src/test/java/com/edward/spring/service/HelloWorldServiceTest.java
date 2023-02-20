package com.edward.spring.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class HelloWorldServiceTest {

    @Autowired
    private HelloWorldService helloWorldService;

    @Test
    public void testPrint() {
        // When and Then.
        assertThat(helloWorldService.print()).isEqualTo("Hello World");
    }
}
