package com.edward.spring.controller;

import com.edward.spring.rabbitmq.sender.SimpleQueueSender;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/common")
@RequiredArgsConstructor
public class CommonController {

    private final SimpleQueueSender simpleQueueSender;

    @GetMapping
    public Map<String, String> common() {
        simpleQueueSender.sendMessageToQueue("Hello World!!! And Apple");

        Map<String, String> response = new LinkedHashMap<>();
        response.put("status", "ok");
        response.put("des", "Send message to queue success");
        return response;
    }

}
