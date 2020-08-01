package com.study.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.study.springcloud.entites.CommonResult;
import com.study.springcloud.entites.Payment;
import com.study.springcloud.myhandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", fallback = "fallbackMethod")
    public CommonResult byResource() {
        int i = 10/0;
        return new CommonResult(200, "按资源名称限流测试OK", new Payment(2020L, "serial001"));
    }

    public CommonResult fallbackMethod(Throwable e) {
        return new CommonResult(400,  "限流请求连接(Java异常)的兜底方法：" + e.getMessage());
    }

    public CommonResult handleException(BlockException exception) {
        return new CommonResult(444, /*exception.getClass().getCanonicalName()*/ "\t 服务不可用");
    }


    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl",blockHandler = "byUrlException")//自己没有兜底方法，会返回Sentinel自带默认的限流处理信息
    public CommonResult byUrl() {
        return new CommonResult(200, "按url限流测试OK", new Payment(2020L, "serial002"));
    }

    public static CommonResult byUrlException(BlockException exception) {
        return new CommonResult(4444, "byUrlException:按客户自定义....global HandlerException-----2");
    }

    /**
     * 兜底方法与业务方法剥离开来
     * @return
     */
    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,   //使用blockHandlerClass 和 blockHandler 指定类和方法。
            blockHandler = "handlerException2")
    public CommonResult customerBlockHandler() {
        return new CommonResult(200, "按客戶自定义", new Payment(2020L, "serial003"));
    }
}

