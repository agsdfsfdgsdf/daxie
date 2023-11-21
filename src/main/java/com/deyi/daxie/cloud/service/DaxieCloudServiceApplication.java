package com.deyi.daxie.cloud.service;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitScan;

@Slf4j
@MapperScan("com.deyi.daxie.cloud.service.mapper")
@RetrofitScan("com.deyi.daxie.cloud.service.http")
@SpringBootApplication
@EnableScheduling
public class DaxieCloudServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DaxieCloudServiceApplication.class, args);
    }
}
