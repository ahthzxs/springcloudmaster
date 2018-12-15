package com.zxs.mine.service.event;


import org.springframework.context.ApplicationEvent;

/**
 * 自定义事件对象
 * @author jelly
 *
 */
public class MyAppEvent  extends ApplicationEvent{
    private static final long serialVersionUID = 1L;

    public MyAppEvent(Object source) {
        super(source);
    }
}
