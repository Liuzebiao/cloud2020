package com.study.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.study.springcloud.myhandler.CustomerBlockHandler;
import com.study.springcloud.myhandler.CustomerFallback;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FlowLimitController {

@GetMapping("/testA")
@SentinelResource(value = "testA",
        fallback = "fallbackMethod",
        fallbackClass = CustomerFallback.class,
        defaultFallback = "defaultFallbackMethod"
)
public String testA() {
    int i = 10 / 0;
    return "-----testA";
}

    @GetMapping("/testB")
    @SentinelResource(value = "testB",blockHandler = "exceptionMethod",blockHandlerClass = CustomerBlockHandler.class)
    public String testB() {
        return "-----testB";
    }
}
