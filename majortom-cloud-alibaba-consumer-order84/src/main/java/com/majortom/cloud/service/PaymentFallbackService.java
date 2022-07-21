package com.majortom.cloud.service;

import com.majortom.cloud.pojo.eneity.CommonResult;
import com.majortom.cloud.pojo.eneity.Payment;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </P>
 *
 * @author Major Tom
 * @since 2022/7/21 21:58
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444, "服务降级返回！", new Payment(id, "error"));
    }
}
