package com.plainhu.bank2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @date: 2021-02-06 14:47:41
 * @author: hkt
 * @desc:
 */
@SpringCloudApplication
@EnableFeignClients
@MapperScan("com.plainhu.bank2.mapper")
public class Bank2App {
    public static void main(String[] args) {
        SpringApplication.run(Bank2App.class, args);
    }
}
