package com.majortom.cloud.controller;

import com.majortom.cloud.pojo.eneity.CommonResult;
import com.majortom.cloud.pojo.eneity.Payment;
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

    //public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String INVOKE_URL = "http://majortom-provider-consul-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(INVOKE_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable(value = "id") Long id) {
        return restTemplate.getForObject(INVOKE_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping(value = "/payment/consul")
    public String paymentInfo() {
        return restTemplate.getForObject(INVOKE_URL + "/payment/consul" , String.class);
    }

}
