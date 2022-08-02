package com.edward.spring;

import com.edward.spring.service.impl.HelloWorldServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringTestApplicationTest {

    @Autowired
    private HelloWorldServiceImpl helloWorldServiceImpl;

    @Test
    public void contextLoads() {
        System.out.println("Test Application Context");
    }

    @Test
    public void print() {
        helloWorldServiceImpl.print();
    }
}
