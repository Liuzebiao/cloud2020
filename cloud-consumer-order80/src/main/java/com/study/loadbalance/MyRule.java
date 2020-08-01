package com.study.loadbalance;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 自定义负载均衡算法
 */
@Component
public class MyRule {

    @Bean
    public IRule myRule(){
        // 此处我们就将轮询修改为随机
        // 此处仅做演示,如需真正的自定义负载均衡算法,那就请大佬继续深入的学习吧
        return new RandomRule();
    }
}
