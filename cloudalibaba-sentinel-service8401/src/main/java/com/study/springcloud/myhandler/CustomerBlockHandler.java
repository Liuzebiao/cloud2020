package com.study.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class CustomerBlockHandler {

    public static String exceptionMethod(BlockException exception) {
        return "处理与 Sentinel 配置相关的兜底方法:" + exception;
    }
}

