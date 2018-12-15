package com.zxs.mine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
@tk.mybatis.spring.annotation.MapperScan(basePackages = "com.zxs.mine.infra.mapper")
@SpringBootApplication
//@EnableCaching
//@EnableScheduling
//@EnableSwagger2
@ServletComponentScan
//@ComponentScan(basePackages = {"*.*"})
public class SpringcloudUserApplication {//implements CommandLineRunner {



    public static void main(String[] args) {

        SpringApplication.run(SpringcloudUserApplication.class, args);
    }



}
