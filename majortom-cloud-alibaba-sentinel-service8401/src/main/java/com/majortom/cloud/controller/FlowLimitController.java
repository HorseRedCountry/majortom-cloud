package com.majortom.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

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

    @GetMapping(value = "/testD")
    public String testD() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("******testD**********");
        return "---------------testB";
    }

    @GetMapping(value = "/testE")
    public String testE() {
        log.info("******testE**********");
        int age = 10 / 0;
        return "---------------testE";
    }

    @GetMapping(value = "/testHotkey")
    @SentinelResource(value = "testHotkey", blockHandler = "dealTestHotkey")
    public String testHotkey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        return "---------Test Hotkey";
    }

    public String dealTestHotkey(String p1, String p2, BlockException exception) {
        return "---------dealTestHotkey";
    }

}
