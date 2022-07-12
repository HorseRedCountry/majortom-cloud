package com.majortom.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <p>
 *
 * </P>
 *
 * @author Major Tom
 * @since 2022/7/12 12:11
 */
@EnableEurekaClient
@SpringBootApplication
public class ConfigClient3355 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient3355.class, args);
    }
}
