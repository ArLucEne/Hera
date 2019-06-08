package com.demin.hera.Controller;

import com.demin.hera.Pojo.Item;
import com.demin.hera.Service.ItemService;
import com.demin.hera.Utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/6 8:46;
 */
@RestController
@CrossOrigin   //前后端分离允许跨域调用
@RequestMapping("/item")
public class ItemController {
    @Autowired
    ItemService itemService;



    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Response save(@RequestBody Item item){
        Item result = itemService.save(item);

        if(!result.getItemId().isEmpty())
            return Response.createBySuccess(result);
        else
            return Response.createByError();
    }

    @RequestMapping("/getAll")
    public Response getAll(@RequestParam int pageNum,@RequestParam int pageSize){
        List items = itemService.getAllWithPage(pageNum,pageSize);
        return Response.createBySuccess(items);
    }

    @RequestMapping("/deleteById")
    public Response deleteById(@RequestParam String itemId){
        itemService.deleteById(itemId);
        if (itemService.findById(itemId) == null)
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
