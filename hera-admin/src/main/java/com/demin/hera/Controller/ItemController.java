package com.demin.hera.Controller;

import com.demin.hera.Pojo.Item;
import com.demin.hera.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by  Domain
 * on 2019/6/6 8:46;
 */
@RestController
@CrossOrigin   //前后端分离允许跨域调用
public class ItemController {
    @Autowired
    ItemService itemService;

    @RequestMapping("/getAllItem")
    public Object getAllItem(){
        return itemService.getAll();
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Object saveItem(@RequestBody Item item){
        return itemService.save(item);
    }

}
