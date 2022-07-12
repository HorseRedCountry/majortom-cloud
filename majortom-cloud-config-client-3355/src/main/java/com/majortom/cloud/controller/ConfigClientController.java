package com.majortom.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </P>
 *
 * @author Major Tom
 * @since 2022/7/12 12:14
 */
@RestController
@RequestMapping(value = "/config/client")
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping(value = "/configInfo")
    public String getConfigInfo() {
        return configInfo;
    }

}
