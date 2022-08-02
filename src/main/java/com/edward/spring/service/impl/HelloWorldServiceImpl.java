package com.edward.spring.service.impl;

import com.edward.spring.service.HelloWorldService;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldServiceImpl implements HelloWorldService {

    @Override
    public String print() {
        return "Hello World";
    }
}
