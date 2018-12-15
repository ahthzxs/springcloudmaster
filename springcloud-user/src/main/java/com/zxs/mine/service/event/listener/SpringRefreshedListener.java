package com.zxs.mine.service.event.listener;

import com.zxs.mine.service.event.MyAppEvent;
import com.zxs.mine.service.event.pulisher.SpringContextHelper;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class SpringRefreshedListener implements ApplicationListener<ContextRefreshedEvent>{

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("============SpringRefreshedListener 执行=========== ");
        SpringContextHelper.getApplicationContext().publishEvent(new MyAppEvent("这是一段事件消息"));
    }

}
