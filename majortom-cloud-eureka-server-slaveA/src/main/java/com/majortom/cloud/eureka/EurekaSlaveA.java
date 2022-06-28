package com.majortom.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * <p>
 *
 * </P>
 *
 * @author Major Tom
 * @since 2022/6/28 12:19
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaSlaveA {
    public static void main(String[] args) {
        SpringApplication.run(EurekaSlaveA.class, args);
    }
}
