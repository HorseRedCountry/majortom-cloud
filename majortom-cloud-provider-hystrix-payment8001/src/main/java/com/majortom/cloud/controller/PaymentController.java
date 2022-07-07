package com.majortom.cloud.controller;

import com.majortom.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *
 * </P>
 *
 * @author Major Tom
 * @since 2022/6/22 22:27
 */
@Slf4j
@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;


    @GetMapping(value = "/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable(value = "id") Integer id) {
        String result = paymentService.paymentInfo_OK(id);
        log.info("****查询结果：" + result);
        return result;
    }

    @GetMapping(value = "/hystrix/timeout/{id}/{timeout}")
    public String paymentInfo_timeout(@PathVariable(value = "id") Integer id, @PathVariable(value = "timeout") int timeout) {
        String result = paymentService.paymentInfo_TIMEOUT(id, timeout);
        log.info("****查询结果：" + result);
        return result;
    }

}
