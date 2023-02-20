package com.edward.spring;

import com.edward.spring.controller.CommonController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SpringTestApplicationTest {

    @Autowired
    private Environment environment;
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private CommonController commonController;

    @Test
    @DisplayName("測試-> 啟動 Edward-Spring-Test Service")
    public void testRunEdwardSpringTestApplication() {
        assertThat(environment).isNotNull();
        assertThat(applicationContext).isNotNull();
        assertThat(commonController).isNotNull();
    }
}
