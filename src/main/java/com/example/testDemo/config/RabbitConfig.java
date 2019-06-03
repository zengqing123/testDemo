//package com.example.testDemo.config;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.core.*;
//import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.beans.factory.config.ConfigurableBeanFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Scope;
//
//
///**
// * <b>类   名：</b>RabbitConfig<br/>
// * <b>类描述：</b><br/>
// * <b>创建人：</b>luozengqing<br/>
// * <b>创建时间：</b>2019/5/24 15:14<br/>
// * <b>修改人：</b>luozengqing<br/>
// * <b>修改时间：</b>2019/5/24 15:14<br/>
// * <b>修改备注：</b><br/>
// *
// * @version 1.0.0<br />
// */
//@Configuration
//public class RabbitConfig {
//    private final Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    @Value("${spring.rabbitmq.host}")
//    private String host;
//
//    @Value("${spring.rabbitmq.port}")
//    private int port;
//
//    @Value("${spring.rabbitmq.username}")
//    private String username;
//
//    @Value("${spring.rabbitmq.password}")
//    private String password;
//
//
//    public static final String EXCHANGE_A = "my-mq-exchange_A";
//    public static final String EXCHANGE_B = "my-mq-exchange_B";
//    public static final String EXCHANGE_C = "my-mq-exchange_C";
//
//
//    public static final String QUEUE_A = "QUEUE_A";
//    public static final String QUEUE_B = "QUEUE_B";
//    public static final String QUEUE_C = "QUEUE_C";
//
//    public static final String ROUTINGKEY_A = "spring-boot-routingKey_A";
//    public static final String ROUTINGKEY_B = "spring-boot-routingKey_B";
//    public static final String ROUTINGKEY_C = "spring-boot-routingKey_C";
//
//    @Bean
//    public ConnectionFactory connectionFactory() {
//        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(host,port);
//        connectionFactory.setUsername(username);
//        connectionFactory.setPassword(password);
//        connectionFactory.setVirtualHost("/");
//        connectionFactory.setPublisherConfirms(true);
//        return connectionFactory;
//    }
//
//    @Bean
////    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//    //必须是prototype类型
//    public RabbitTemplate rabbitTemplate() {
//        RabbitTemplate template = new RabbitTemplate(connectionFactory());
//        return template;
//    }
//
////    @Bean
////    public DirectExchange defaultExchange() {
////        return new DirectExchange(EXCHANGE_A);
////    }
//
//    /**
//     * 获取队列A
//     * @return
//     */
//    @Bean
//    public Queue queueB() {
//        return new Queue(QUEUE_B); //队列持久
//    }
//
//    @Bean
//    FanoutExchange fanoutExchange() {
//        return new FanoutExchange(RabbitConfig.EXCHANGE_B);
//    }
//
//    @Bean
//    public Binding binding(Queue queueB, FanoutExchange fanoutExchange) {
//
//        return BindingBuilder.bind(queueB).to(fanoutExchange);
//    }
//
//
//}
