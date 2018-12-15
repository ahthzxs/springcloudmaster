package com.zxs.mine.service.event.pulisher;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;


/**
 * Spring 容器上下文辅助类
 * @author jelly
 *
 */
@Component
public class SpringContextHelper implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        SpringContextHelper.applicationContext = applicationContext;
    }

    /**
     * 获取spring容器的 applicationContext 上下文对象
     * @return
     */
    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    public static Object getBean(String name){
        return applicationContext.getBean(name);
    }


    /**
     * 发布事件到spring
     * @param event
     */
    public static void pushEvent(ApplicationEvent event) {
        applicationContext.publishEvent(event);
    }



    /**
     * 从spring 上下文中获取bean
     * @param name
     * @param requiredClass
     * @return
     */
//    public static T getBean(String name, Class  requiredClass){
//        return applicationContext.getBean(name, requiredClass);
//    }
//    public  static  T getBean(Class requiredType){
//        return applicationContext.getBean(requiredType);
//    }


}
