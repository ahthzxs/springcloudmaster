package com.zxs.springcloud.springcloudapi.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("springcloud-user")
public interface HelloService {

    @GetMapping("/user/demo")
    String hello();
}