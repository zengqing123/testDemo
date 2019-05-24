package com.example.testDemo.config;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * <b>类   名：</b>Receiver<br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>luozengqing<br/>
 * <b>创建时间：</b>2019/5/24 15:13<br/>
 * <b>修改人：</b>luozengqing<br/>
 * <b>修改时间：</b>2019/5/24 15:13<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0.0<br />
 */
@Component
@RabbitListener(queues = RabbitConfig.QUEUE_B)
public class Receiver {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver : " + hello);
    }
}
