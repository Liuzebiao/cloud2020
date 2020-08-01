package com.study.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        /**
         * 配置了一个 id 为 "toBaiduGuoNei" 的路由规则，当访问地址 http://localhost:9527/guonei 时会自动转发到地址：http://news.baidu.com/guonei
         */
        return builder.routes()
                .route("toBaiduGuoNei",r -> r.path("/guonei").uri("https://news.baidu.com/guonei"))
                .build();
    }
}
