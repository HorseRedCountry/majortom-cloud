package com.majortom.cloud.myrule;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.loadbalancer.core.ReactorServiceInstanceLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *
 * </P>
 *
 * @author Major Tom
 * @since 2022/7/4 13:01
 */
@Configuration
public class MajorTomRule {

    @Bean
    public ReactorServiceInstanceLoadBalancer customLoadBalancer(ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSupplierProvider){
        return new MajorTomRandomRule(serviceInstanceListSupplierProvider);
    }

}
