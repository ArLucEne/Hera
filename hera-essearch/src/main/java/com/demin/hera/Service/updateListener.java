package com.demin.hera.Service;

import com.demin.hera.Entity.EsItem;
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
public class updateListener {

    @Autowired
    essearch service;

    @RabbitHandler
    public void receiver(String msg){
        if (!msg.isEmpty()) {
            System.out.println(service.syncData());
        }

    }
}
