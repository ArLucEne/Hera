package com.demin.hera.Controller;

import com.demin.hera.Pojo.Item;
import com.demin.hera.Service.ItemService;
import com.demin.hera.Utils.Response;
import com.github.pagehelper.PageInfo;
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
    @Autowired
    ItemService itemService;

    @Autowired
    private AmqpTemplate amqpTemplate;


    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Response save(@RequestBody Item item){
        Item result = itemService.save(item);

        amqpTemplate.convertAndSend("itemQueue",result.toString());    //向消息队列发送更新消息
        System.out.println("sent message to queue");
        if(!result.getItemId().isEmpty())
            return Response.createBySuccess(result);
        else
            return Response.createByError();
    }

    @RequestMapping("/getAll")
    public Response getAll(@RequestParam int pageNum,@RequestParam int pageSize){
        PageInfo<Item> items = itemService.getAllWithPage(pageNum,pageSize);
        amqpTemplate.convertAndSend("itemQueue","hello");    //向消息队列发送更新消息
        return Response.createBySuccess(items);
    }

    @RequestMapping("getAllItems")
    public List<Item> getAllItems(){
        return itemService.findAllItems();
    }

    @RequestMapping("/deleteById")
    public Response deleteById(@RequestParam String itemId){
        itemService.deleteById(itemId);
        if (!itemService.existById(itemId))
            return Response.createBySuccess();
        else
            return Response.createByError();
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Response update(@RequestBody Item item){
        Item resule = itemService.update(item);
        if (resule != null) {
            return Response.createBySuccess(resule);
        }else
            return Response.createByError();
    }

    @RequestMapping("/findById")
    public Response findById(@RequestParam String itemId){
        Item result = itemService.findById(itemId);
        if(result != null)
            return Response.createBySuccess(result);
        else
            return Response.createByError();
    }

}
