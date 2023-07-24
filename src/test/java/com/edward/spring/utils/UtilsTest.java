package com.edward.spring.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
public class UtilsTest {

    @Test
    public void testGenerateRandomDigital() {
        String randomStr = Utils.generateRandomDigital(5);
        log.info(randomStr);
        assertThat(randomStr).hasSize(5);

        randomStr = Utils.generateRandomDigital(6);
        log.info(randomStr);
        assertThat(randomStr).hasSize(6);

        randomStr = Utils.generateRandomDigital(7);
        log.info(randomStr);
        assertThat(randomStr).hasSize(7);

        randomStr = Utils.generateRandomDigital(8);
        log.info(randomStr);
        assertThat(randomStr).hasSize(8);
    }
}
