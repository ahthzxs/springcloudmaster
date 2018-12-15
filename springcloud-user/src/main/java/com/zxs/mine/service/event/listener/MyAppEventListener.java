package com.zxs.mine.service.event.listener;


import com.zxs.mine.service.event.MyAppEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


/**
 * 自定义事件MyAppEvent的监听器
 * @author jelly
 *
 */
@Component
public class MyAppEventListener  implements ApplicationListener<MyAppEvent>{

    @Override
    public void onApplicationEvent(MyAppEvent event) {
        System.out.println("MyAppEventListener监听到MyAppEvent事件发生");
        System.out.println("事件source:"+event.getSource());//时间源对象
        System.out.println("事件timestamp:"+event.getTimestamp());
        System.out.println("事件class:"+event.getClass());

    }

}
