package com.demin.hera.Config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by  Domain
 * on 2019/6/9 15:24;
 */
@Configuration
public class rabbitmqConfig {
    @Bean
    public Queue initQueue(){
        return new Queue("itemQueue");
    }
}
