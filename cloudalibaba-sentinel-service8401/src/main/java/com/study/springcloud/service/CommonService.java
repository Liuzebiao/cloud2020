package com.study.springcloud.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("commonService")
@Slf4j
public class CommonService {

    @SentinelResource(value = "testA01")
    public void testA01() {
        testA02();
        testA04();
        log.info("-----testA01");
    }

    @SentinelResource(value = "testA02")
    public void testA02() {
        testA03();
        log.info("-----testA02");
    }

    @SentinelResource(value = "testA03")
    public void testA03() {
        log.info("-----testA03");
    }

    @SentinelResource(value = "testA04")
    public void testA04() {
        testA05();
        log.info("-----testA04");
    }

    @SentinelResource(value = "testA05")
    public void testA05() {
        log.info("-----testA05");
    }
}
