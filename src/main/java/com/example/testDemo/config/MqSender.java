package com.example.testDemo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * <b>类   名：</b>MqSender<br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>luozengqing<br/>
 * <b>创建时间：</b>2019/5/24 14:49<br/>
 * <b>修改人：</b>luozengqing<br/>
 * <b>修改时间：</b>2019/5/24 14:49<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0.0<br />
 */
@Component
public class MqSender{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //由于rabbitTemplate的scope属性设置为ConfigurableBeanFactory.SCOPE_PROTOTYPE，所以不能自动注入
    @Autowired
    private RabbitTemplate rabbitTemplate;
    /**
     * 构造方法注入rabbitTemplate
     */
//    @Autowired
//    public MqSender(RabbitTemplate rabbitTemplate) {
//        this.rabbitTemplate = rabbitTemplate;
//        rabbitTemplate.setConfirmCallback(this); //rabbitTemplate如果为单例的话，那回调就是最后设置的内容
//    }

    public void sendMsg(String content) {
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_B, RabbitConfig.ROUTINGKEY_B, content,correlationId);
    }

}
