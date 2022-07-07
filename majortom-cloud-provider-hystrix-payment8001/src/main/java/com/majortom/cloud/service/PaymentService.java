package com.majortom.cloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

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
public class PaymentService {

    public String paymentInfo_OK(Integer id){
        return "线程池：  " + Thread.currentThread().getName() + "    paymentInfo_timeoutHandler,id:    " + id + "\t" + "***" + "ok ";

    }

    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_TIMEOUT(Integer id, int timeNumber){
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：  " + Thread.currentThread().getName() + "    paymentInfo_TIMEOUT,id:    " + id + "\t" + "***" + "耗时: " + timeNumber;
    }

    public String paymentInfoTimeOutHandler(Integer id, int timeNumber){
        return "线程池：  " + Thread.currentThread().getName() + "    paymentInfo_timeoutHandler,id:    " + id + "\t" + "***" + "访问超时了 ";
    }

}
