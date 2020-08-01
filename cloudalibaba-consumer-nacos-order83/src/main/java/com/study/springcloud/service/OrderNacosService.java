package com.study.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(value = "nacos-payment-provider") //添加@FeignClient注解,指定服务提供方服务名称
public interface OrderNacosService {

    //OpenFeign支持Spring MVC注解,此处通过@GetMapping去调用 CLOUD-PAYMENT-SERVICE 该服务指定的接口
    @GetMapping(value = "/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id);
}
