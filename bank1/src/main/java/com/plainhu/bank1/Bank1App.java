package com.plainhu.bank1;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @date: 2021-02-06 14:39:36
 * @author: hkt
 * @desc:
 */
@SpringCloudApplication
@EnableFeignClients
@MapperScan("com.plainhu.bank1.mapper")
public class Bank1App {
    public static void main(String[] args) {
        SpringApplication.run(Bank1App.class, args);
    }
}
