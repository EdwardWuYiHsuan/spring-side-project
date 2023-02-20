package com.edward.spring.client;

import com.edward.spring.client.response.QueryHealthCheckResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
public class MockApiClientIntegrationTest {

    @Autowired
    private MockApiClient mockApiClient;

    @Test
    public void testHealthCheck() {
        // When.
        QueryHealthCheckResponse response = mockApiClient.healthCheck();
        log.info("{}", response);

        // Then.
        Assertions.assertNotNull(response);
        Assertions.assertEquals(0, response.getCode());
        Assertions.assertEquals("suc", response.getMsg());
        Assertions.assertNull(response.getData());
        Assertions.assertNotNull(response.getTimestamp());
        assertThat(response.getRequestId()).isEqualTo("95xB2GqH");
    }
}
