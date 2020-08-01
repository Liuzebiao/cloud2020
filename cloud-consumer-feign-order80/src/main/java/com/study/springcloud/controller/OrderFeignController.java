package com.study.springcloud.controller;

import com.study.springcloud.entites.CommonResult;
import com.study.springcloud.entites.Payment;
import com.study.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderFeignController {

    //此处就可以通过调用Service来完成 Controller → Service
    //具体Service具体业务怎么调用，具体业务实现就由它随便实现吧
    //这就是 OpenFeign 相比 RestTemplate 的好处
    @Resource
    private PaymentFeignService paymentFeignService;

    //80(就是客户端这块80)
    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }
}
