package com.majortom.cloud.service;

import com.majortom.cloud.pojo.eneity.CommonResult;
import com.majortom.cloud.pojo.eneity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>
 *
 * </P>
 *
 * @author Major Tom
 * @since 2022/7/5 21:47
 */
@Component
@FeignClient(value = "MAJORTOM-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feign/timeout")
    String paymentFeignTimeout();
}
