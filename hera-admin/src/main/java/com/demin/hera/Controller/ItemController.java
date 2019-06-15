package com.demin.hera.Controller;


import com.demin.hera.Entity.Item;
import com.demin.hera.Entity.ItemCategory;
import com.demin.hera.Entity.Response;
import com.demin.hera.Feign.ItemCategoryFeign;
import com.demin.hera.Feign.ItemFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
import java.util.UUID;

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
    ItemCategoryFeign feign;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @PostMapping(value = "/save")
    public Response save(@RequestBody Item item){
        item.setItemId(UUID.randomUUID().toString().replaceAll("-",""));
        String id = "11";
        System.out.println(item);
        ItemCategory category = feign.findById(id);
        item.setItemCatName(category.getName());
        item.setStatus(1);
        Item result = itemService.save(item);
        LOGGER.info("ITEM FEIGN TO HERA-BASE USE SAVE");
        amqpTemplate.convertAndSend("itemQueue",result.toString());    //向消息队列发送更新消息
        LOGGER.info("RABBITMQ SEND MES TO ITEMQUEUE");
        if(!result.getItemId().isEmpty())
            return Response.createBySuccess(result);
        else
            return Response.createByError();
    }


    @GetMapping("/getAll")
    public Response getAll(@RequestParam int pageNum,@RequestParam int pageSize){
        Object items = itemService.findAllWithPage(pageNum,pageSize);
        LOGGER.info("ITEM FEIGN TO HERA-BASE USE FINDALLWITHPAGE");
        return Response.createBySuccess(items);
    }


    @GetMapping("/getAllItems")
    public Response getAll(){
        LOGGER.info("ITEM FEIGN TO HERA-BASE USE FINDALL");
        return Response.createBySuccess(itemService.findAll());
    }

    @GetMapping("/deleteById")
    public Response deleteById(@RequestParam String itemId){
        itemService.deleteById(itemId);
        LOGGER.info("ITEM FEIGN TO HERA-BASE USE DELETEBYID");
        if (!itemService.existById(itemId))
            return Response.createBySuccess();
        else
            return Response.createByError();
    }

    @PostMapping(value = "/update")
    public Response update(@RequestBody Item item){
        Item resule = itemService.update(item);
        LOGGER.info("ITEM FEIGN TO HERA-BASE USE UPDATE");
        if (resule != null) {
            return Response.createBySuccess(resule);
        }else
            return Response.createByError();
    }

    @GetMapping("/findById")
    public Response findById(@RequestParam String itemId){
        Item result = itemService.findById(itemId);
        LOGGER.info("ITEM FEIGN TO HERA-BASE USE FINDBYID");
        if(result != null)
            return Response.createBySuccess(result);
        else
            return Response.createByError();
    }

}
