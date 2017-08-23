package org.exchange.rates.integration;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.TestPropertySource;

@Configuration
@EnableFeignClients
@ComponentScan(basePackages = {"org.exchange.rates"})
@TestPropertySource("classpath:application-intTest.properties")
public class SpringTestConfig {
}
