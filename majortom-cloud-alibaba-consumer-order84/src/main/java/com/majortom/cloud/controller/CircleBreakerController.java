package com.majortom.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.majortom.cloud.pojo.eneity.CommonResult;
import com.majortom.cloud.pojo.eneity.Payment;
import com.majortom.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * <p>
 *
 * </P>
 *
 * @author Major Tom
 * @since 2022/7/21 20:58
 */
@Slf4j
@RestController
public class CircleBreakerController {

    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/fallback/{id}")
    //@SentinelResource(value = "fallback")
    @SentinelResource(value = "fallback", fallback = "handlerFallback")
    public CommonResult<Payment> fallback(@PathVariable Long id) {
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class, id);
        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException----非法参数异常！");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException-----空指针异常，该ID没有对应的记录！------>" + id);
        }
        return result;
    }

    public CommonResult<Payment> handlerFallback(@PathVariable Long id, Throwable e) {
        Payment payment = new Payment(id, null);
        return new CommonResult<>(444, "兜底异常----" + e.getMessage(), payment);
    }

    @Resource
    private PaymentService paymentService;

    @RequestMapping(value = "/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable Long id) {

        return paymentService.paymentSQL(id);
    }

}
