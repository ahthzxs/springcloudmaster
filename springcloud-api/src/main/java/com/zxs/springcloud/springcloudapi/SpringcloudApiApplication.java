package com.zxs.springcloud.springcloudapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
//@ComponentScan(basePackages={"com.zxs.springcloud.springcloudapi"})
public class SpringcloudApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudApiApplication.class, args);
    }

}

