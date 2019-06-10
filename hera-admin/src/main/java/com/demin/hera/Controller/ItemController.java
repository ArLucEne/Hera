package com.demin.hera.Controller;


import com.demin.hera.Entity.Item;
import com.demin.hera.Entity.Response;
import com.demin.hera.Feign.ItemFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/6 8:46;
 */
@RestController
//@CrossOrigin   //前后端分离允许跨域调用
@RequestMapping("/item")
public class ItemController {

    public static final Logger LOGGER = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    ItemFeign itemService;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Response save(@RequestBody Item item){
        Item result = itemService.save(item);
        LOGGER.info("ITEM FEIGN TO HERA-BASE USE SAVE");
        amqpTemplate.convertAndSend("itemQueue",result.toString());    //向消息队列发送更新消息
        LOGGER.info("RABBITMQ SEND MES TO ITEMQUEUE");
        if(!result.getItemId().isEmpty())
            return Response.createBySuccess(result);
        else
            return Response.createByError();
    }


    @RequestMapping("/getAll")
    public Response getAll(@RequestParam int pageNum,@RequestParam int pageSize){
        Object items = itemService.findAllWithPage(pageNum,pageSize);
        LOGGER.info("ITEM FEIGN TO HERA-BASE USE FINDALLWITHPAGE");
        return Response.createBySuccess(items);
    }


    @RequestMapping("/getAllItems")
    public List<Item> getAll(){
        LOGGER.info("ITEM FEIGN TO HERA-BASE USE FINDALL");
        return itemService.findAll();
    }

    @RequestMapping("/deleteById")
    public Response deleteById(@RequestParam String itemId){
        itemService.deleteById(itemId);
        LOGGER.info("ITEM FEIGN TO HERA-BASE USE DELETEBYID");
        if (!itemService.existById(itemId))
            return Response.createBySuccess();
        else
            return Response.createByError();
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Response update(@RequestBody Item item){
        Item resule = itemService.update(item);
        LOGGER.info("ITEM FEIGN TO HERA-BASE USE UPDATE");
        if (resule != null) {
            return Response.createBySuccess(resule);
        }else
            return Response.createByError();
    }

    @RequestMapping("/findById")
    public Response findById(@RequestParam String itemId){
        Item result = itemService.findById(itemId);
        LOGGER.info("ITEM FEIGN TO HERA-BASE USE FINDBYID");
        if(result != null)
            return Response.createBySuccess(result);
        else
            return Response.createByError();
    }

}
