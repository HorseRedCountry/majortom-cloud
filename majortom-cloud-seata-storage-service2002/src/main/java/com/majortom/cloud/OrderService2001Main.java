package com.majortom.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <p>
 *
 * </P>
 *
 * @author Major Tom
 * @since 2022/7/24 23:09
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderService2001Main {
    public static void main(String[] args) {
        SpringApplication.run(OrderService2001Main.class, args);
    }
}
