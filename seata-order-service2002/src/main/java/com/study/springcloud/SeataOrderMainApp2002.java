package com.study.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@MapperScan("com.study.springcloud.dao")
public class SeataOrderMainApp2002 {
    public static void main(String[] args) {
        SpringApplication.run(SeataOrderMainApp2002.class, args);
    }
}

