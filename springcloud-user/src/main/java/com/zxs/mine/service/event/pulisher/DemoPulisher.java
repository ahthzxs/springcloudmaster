package com.zxs.mine.service.event.pulisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

@Component
public class DemoPulisher  {

    @Autowired
    ApplicationContext applicationContext;


    public void publish(ApplicationEvent applicationEvent){

        applicationContext.publishEvent(applicationEvent);
    }


}