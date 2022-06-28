package com.majortom.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <p>
 * 支付模块 启动类
 * </P>
 *
 * @author Major Tom
 * @since 2022/6/22 21:36
 */
@SpringBootApplication
@EnableEurekaClient
public class Payment8002Main {
    public static void main(String[] args) {
        SpringApplication.run(Payment8002Main.class, args);
    }
}
