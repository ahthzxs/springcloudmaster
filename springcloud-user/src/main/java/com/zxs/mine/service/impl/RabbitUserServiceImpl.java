package com.zxs.mine.service.impl;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yukong
 * @date 2018/8/22
 * @description rabbit消息生产者
 */
@Component
public class RabbitUserServiceImpl {

    //普通模式
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void stringSend() {
        Date date = new Date();
        String dateString = new SimpleDateFormat("YYYY-mm-DD hh:MM:ss").format(date);
        System.out.println("[string] send msg:" + dateString);
        // 第一个参数为刚刚定义的队列名称
        this.rabbitTemplate.convertAndSend("string", dateString);
    }

    //fanout交换机模式
    public void fanoutSend() {
        Date date = new Date();
        String dateString = new SimpleDateFormat("YYYY-mm-DD hh:MM:ss").format(date);
        System.out.println("[fanout] send msg:" + dateString);
        // 注意 第一个参数是我们交换机的名称 ，第二个参数是routerKey 我们不用管空着就可以，第三个是你要发送的消息
        this.rabbitTemplate.convertAndSend("fanoutExchange", "", dateString);
    }
}


/*
//以下为相应消费者监听消息
package com.yukong.rabbitmqconsumer;

        import org.springframework.amqp.core.AmqpTemplate;
        import org.springframework.amqp.rabbit.annotation.RabbitHandler;
        import org.springframework.amqp.rabbit.annotation.RabbitListener;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Component;

*/
/**
 * @author yukong
 * @date 2018/8/22
 * @description rabbitmq消费者 @RabbitListener(queues = "simpleMsg") 监听名simpleMsg的队列
 *//*

@Component
@RabbitListener(queues = "string")
public class StringConsumer {

    @Autowired private AmqpTemplate rabbitmqTemplate;

    */
/**
     * 消息消费
     * @RabbitHandler 代表此方法为接受到消息后的处理方法
     *//*

    @RabbitHandler
    public void recieved(String msg) {
        System.out.println("[string] recieved message:" + msg);
    }

}*/


//-------------------------交换机模式开始
/*@Component
@RabbitListener(queues = "fanout.a")
public class FanoutAConsumer {

    @Autowired
    private AmqpTemplate rabbitmqTemplate;

    *//**
     * 消息消费
     * @RabbitHandler 代表此方法为接受到消息后的处理方法
     *//*
    @RabbitHandler
    public void recieved(String msg) {
        System.out.println("[fanout.a] recieved message:" + msg);
    }
}*/

//---------------------------交换机模式结束