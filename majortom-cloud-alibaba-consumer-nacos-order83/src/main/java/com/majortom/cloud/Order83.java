package com.majortom.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p>
 *
 * </P>
 *
 * @author Major Tom
 * @since 2022/7/13 19:52
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Order83 {
    public static void main(String[] args) {
        SpringApplication.run(Order83.class, args);
    }
}
