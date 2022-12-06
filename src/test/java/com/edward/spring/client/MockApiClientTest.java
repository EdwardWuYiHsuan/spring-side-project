package com.edward.spring.client;

import com.edward.spring.client.response.QueryHealthCheckResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MockApiClientTest {

    @Autowired
    private MockApiClient mockApiClient;

    @Test
    public void testHealthCheck() {
        // When.
        QueryHealthCheckResponse response = mockApiClient.healthCheck();

        // Then.
        Assertions.assertNotNull(response);
        Assertions.assertEquals(0, response.getCode());
        Assertions.assertEquals("suc", response.getMsg());
        Assertions.assertNull(response.getData());
        Assertions.assertNotNull(response.getTimestamp());
        Assertions.assertEquals("95xB2GqH", response.getRequestId());
        System.out.println(response);
    }
}
