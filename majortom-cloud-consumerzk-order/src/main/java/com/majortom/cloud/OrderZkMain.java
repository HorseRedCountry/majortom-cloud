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
 * @since 2022/6/29 12:59
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZkMain {
    public static void main(String[] args) {
        SpringApplication.run(OrderZkMain.class,args);
    }
}
