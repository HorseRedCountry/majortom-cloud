package com.majortom.cloud.controller;

import com.google.common.collect.Maps;
import com.majortom.cloud.pojo.eneity.CommonResult;
import com.majortom.cloud.pojo.eneity.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 *
 * </P>
 *
 * @author Major Tom
 * @since 2022/7/21 20:45
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static Map<Long, Payment> hashMap = Maps.newHashMap();

    static {
        hashMap.put(1L, new Payment(1L, "serial001"));
        hashMap.put(2L, new Payment(2L, "serial002"));
        hashMap.put(3L, new Payment(3L, "serial003"));
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable(value = "id") Long id) {
        Payment payment = hashMap.get(id);
        return new CommonResult(200, "from sql data,serverPort: " + serverPort, payment);
    }

}
