package com.majortom.cloud.controller;

import com.majortom.cloud.pojo.eneity.CommonResult;
import com.majortom.cloud.pojo.eneity.Payment;
import com.majortom.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

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

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入成功！serverPort:"+serverPort, result);
        } else {
            return new CommonResult(444, "插入失败！");
        }
    }

    @GetMapping(value = "/get/{id}")
    public CommonResult getById(@PathVariable Long id) {
        Payment result = paymentService.getPaymentById(id);
        log.info("****查询结果：" + result);
        if (null != result) {
            return new CommonResult(200, "查询成功！serverPort:"+serverPort, result);
        } else {
            return new CommonResult(444, "查询失败！没有对应记录" + id);
        }
    }

    @GetMapping(value = "/feign/timeout")
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(30);
        }catch (InterruptedException e){
            e.printStackTrace();;
        }
        return serverPort;
    }

}
