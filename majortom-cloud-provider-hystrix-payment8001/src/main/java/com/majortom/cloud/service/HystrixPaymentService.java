package com.majortom.cloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * </P>
 *
 * @author Major Tom
 * @since 2022/6/22 22:23
 */
@Service
public class HystrixPaymentService {

    public String paymentInfo_OK(Integer id) {
        return "线程池：  " + Thread.currentThread().getName() + "    paymentInfo_timeoutHandler,id:    " + id + "\t" + "***" + "ok ";

    }

    //服务降级
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_TIMEOUT(Integer id, int timeNumber) {
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：  " + Thread.currentThread().getName() + "    paymentInfo_TIMEOUT,id:    " + id + "\t" + "***" + "耗时: " + timeNumber;
    }

    public String paymentInfoTimeOutHandler(Integer id, int timeNumber) {
        return "线程池：  " + Thread.currentThread().getName() + "    paymentInfo_timeoutHandler,id:    " + id + "\t" + "***" + "访问超时了 ";
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            //请求次数
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            //时间窗口期
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            //失败次数
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
    })
    public String paymentCircuitBreaker(@PathVariable(value = "id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("**************id 不能为负数！");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号： " + serialNumber;
    }

    public String paymentCircuitBreakerFallback(@PathVariable(value = "id") Integer id) {
        return "id 不能为负数，请稍后重试----------id： " + id;
    }


}
