package com.majortom.cloud.service;

import com.majortom.cloud.pojo.eneity.CommonResult;
import com.majortom.cloud.pojo.eneity.Payment;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 服务降级方法
 * </P>
 *
 * @author Major Tom
 * @since 2022/7/7 23:12
 */
@Component
public class PaymentFallbackService implements PaymentFeignHystrixService {
    @Override
    public CommonResult<Payment> getPaymentById(Long id) {
        return null;
    }

    @Override
    public String paymentInfo_ok(Integer id) {
        return "---------from PaymentFallbackService paymentInfo_ok";
    }

    @Override
    public String paymentInfo_timeout(Integer id, int timeout) {
        return "---------from PaymentFallbackService paymentInfo_timeout";
    }
}
