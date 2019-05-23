package com.jude.file.config;

import com.rabbitmq.client.impl.AMQImpl;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @author ：wupeng
 * @date ：Created in 15:45 2019/4/2
 * @description：
 */
@Configuration
public class RabbitmqConfig {
    public static final String QUEUE_NAME = "spring-boot-simple";

    @Bean
    public Queue queue(){
        return new Queue(QUEUE_NAME);
    }
}
