package com.zxs.mine.api.config;


import com.zxs.mine.api.interceptor.JwtInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//@Configuration
public abstract class WebConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //添加拦截器
        registry.addInterceptor(
                new JwtInterceptor())
                .excludePathPatterns("/hello","/register","/login", "/user/login","/user/*");//放掉某些特定不需要校验token的路由

    }

}


