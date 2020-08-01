package com.study.springcloud.myhandler;

public class CustomerFallback {

    public static String defaultFallbackMethod(Throwable e) {
        return "通用的fallback兜底方法";
    }

    public static String fallbackMethod(Throwable e) {
        return "限流请求连接(Java类异常)的兜底方法：" + e.getMessage();
    }
}
