package com.demin.hera.Service;

import com.demin.hera.Entity.EsItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by  Domain
 * on 2019/6/9 15:13;
 */
@Service
@RabbitListener(queues = "itemQueue")
public class UpdateListener {

    public static final Logger logger = LoggerFactory.getLogger(UpdateListener.class);

    @Autowired
    Essearch service;

    @RabbitHandler
    public void receiver(String msg){
        if (!msg.isEmpty()) {
            logger.info("get msg from rabbitmq queue to sync Data");
            service.syncData();
        }

    }
}
