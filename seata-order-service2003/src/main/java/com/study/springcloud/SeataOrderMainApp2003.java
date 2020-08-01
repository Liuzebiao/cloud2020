package com.study.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.study.springcloud.dao")
@SpringBootApplication
public class SeataOrderMainApp2003 {
    public static void main(String[] args) {
        SpringApplication.run(SeataOrderMainApp2003.class, args);
    }
}
