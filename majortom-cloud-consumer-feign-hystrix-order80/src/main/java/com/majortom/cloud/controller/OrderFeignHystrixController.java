package com.majortom.cloud.controller;

import com.majortom.cloud.pojo.eneity.CommonResult;
import com.majortom.cloud.pojo.eneity.Payment;
import com.majortom.cloud.service.PaymentFeignHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
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
 * @since 2022/7/5 21:53
 */
@RestController
@Slf4j
@RequestMapping(value = "/order")
@DefaultProperties(defaultFallback = "globalFallbackMethod")
public class OrderFeignHystrixController {

    @Resource
    private PaymentFeignHystrixService paymentFeignService;

    @GetMapping(value = "/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable(value = "id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/hystrix/feign/ok/{id}")
    String paymentInfo_ok(@PathVariable Integer id) {
        return paymentFeignService.paymentInfo_ok(id);
    }

    @GetMapping(value = "/hystrix/feign/timeout/{id}/{timeout}")
//    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandlerMethod", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    @HystrixCommand
    String paymentInfo_timeout(@PathVariable Integer id, @PathVariable int timeout) {
        return paymentFeignService.paymentInfo_timeout(id, timeout);
    }

    String paymentInfoTimeOutHandlerMethod(@PathVariable Integer id, @PathVariable int timeout) {
        return "服务方繁忙，请重试！";
    }

    String globalFallbackMethod() {
        return "服务方繁忙，请重试！ ------全局fallback";
    }


}
