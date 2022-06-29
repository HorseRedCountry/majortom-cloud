package com.majortom.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p>
 * 支付模块 启动类
 * </P>
 *
 * @author Major Tom
 * @since 2022/6/22 21:36
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Payment8004Main {
    public static void main(String[] args) {
        SpringApplication.run(Payment8004Main.class, args);
    }
}
