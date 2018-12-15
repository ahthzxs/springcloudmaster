package com.zxs.mine.service.event.listener;


import com.zxs.mine.service.event.MyAppEvent;
import com.zxs.mine.service.event.pulisher.SpringContextHelper;
import org.springframework.context.event.*;
import org.springframework.stereotype.Component;



@Component
public class SpringContextEventHandler {

    @EventListener
    public void stopped(ContextStoppedEvent event){
        System.out.println("SpringContextEventHandler stopped执行");
    }

    @EventListener
    public void started(ContextStartedEvent event){
        System.out.println("SpringContextEventHandler started执行");
    }

    @EventListener
    public void refreshed(ContextRefreshedEvent event){
        System.out.println("SpringContextEventHandler refreshed执行");

        SpringContextHelper.getApplicationContext().publishEvent(new MyAppEvent("这是一段事件消息"));

    }
    @EventListener
    public void closed(ContextClosedEvent event){
        System.out.println("SpringContextEventHandler closed执行");
    }

}

