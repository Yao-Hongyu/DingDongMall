package com.dingdong.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.dingdong.mall.mappers")
@EnableCaching
public class DingDongMallApplication {

    public static void main(String[] args) {
        SpringApplication.run(DingDongMallApplication.class, args);
    }

}
