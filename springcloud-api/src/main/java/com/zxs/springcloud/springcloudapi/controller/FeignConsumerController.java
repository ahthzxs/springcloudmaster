package com.zxs.springcloud.springcloudapi.controller;

import com.zxs.springcloud.springcloudapi.service.feign.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignConsumerController {

    @Autowired
    HelloService helloService;

    @GetMapping("hello2")
    public String hello() {
        return helloService.hello();
    }
}