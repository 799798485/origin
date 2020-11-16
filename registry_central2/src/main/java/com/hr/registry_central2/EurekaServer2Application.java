package com.hr.registry_central2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


//开启 启用
//注册中心
@EnableEurekaServer
@SpringBootApplication
public class EurekaServer2Application {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer2Application.class);
    }
}