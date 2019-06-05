package com.demin.hera.Controller;

import com.demin.hera.Pojo.Item;
import com.demin.hera.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by  Domain
 * on 2019/6/5 9:19;
 */
@RestController
public class TestContorller {
    @Autowired
    ItemService service;
    @RequestMapping("/test")
    public Object test(@RequestParam Integer id){
        return service.findById(id);
    }

    @RequestMapping("/testSave")
    public Object testSave(){
        Item item = Item.getTestEntity();
        return service.save(item);
    }
}
