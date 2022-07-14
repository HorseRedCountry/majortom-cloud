package com.majortom.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </P>
 *
 * @author Major Tom
 * @since 2022/7/14 12:35
 */
@Slf4j
@RestController
public class FlowLimitController {

    @GetMapping(value = "/testA")
    public String testA() {
        return "---------------testA";
    }

    @GetMapping(value = "/testB")
    public String testB() {
        log.info(Thread.currentThread().getName() + "\t" + "******testB");
        return "---------------testB";
    }

}
