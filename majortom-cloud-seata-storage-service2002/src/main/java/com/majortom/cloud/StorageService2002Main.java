package com.majortom.cloud;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
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
@EnableAutoDataSourceProxy
public class StorageService2002Main {
    public static void main(String[] args) {
        SpringApplication.run(StorageService2002Main.class, args);
    }
}
