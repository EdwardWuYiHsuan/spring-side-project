package com.edward.spring.client;

import com.edward.spring.client.response.CompoundGetTokenApyResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
public class CompoundApiClientTest {

    @Value("${server.compound.contract-address.usdt}")
    private String compoundContractAddressUsdt;
    @Autowired
    private CompoundApiClient compoundApiClient;

    @Test
    public void testGetTokenApy() {
        // Given.
        List<String> contractAddress = Stream.of(compoundContractAddressUsdt).collect(Collectors.toList());

        // When.
        CompoundGetTokenApyResponse response = compoundApiClient.getTokenApy(contractAddress);

        // Then.
        Assertions.assertNotNull(response);
        System.out.println(response);
    }
}
