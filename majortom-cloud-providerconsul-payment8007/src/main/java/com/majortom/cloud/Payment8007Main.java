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
 * @since 2022/6/29 21:58
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Payment8007Main {
    public static void main(String[] args) {
        SpringApplication.run(Payment8007Main.class, args);
    }
}
