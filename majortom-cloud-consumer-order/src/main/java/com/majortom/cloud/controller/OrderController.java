package com.majortom.cloud.controller;

import com.majortom.cloud.eneity.CommonResult;
import com.majortom.cloud.eneity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
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
 * @since 2022/6/22 23:16
 */
@Slf4j
@RestController
@RequestMapping(value = "/consummer")
public class OrderController {

    public static final String PAYMENT_URL = "http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get" + id, CommonResult.class);
    }

}
