package com.majortom.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <p>
 *
 * </P>
 *
 * @author Major Tom
 * @since 2022/7/7 12:26
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class HytrixPaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(HytrixPaymentMain8001.class, args);
    }
}
