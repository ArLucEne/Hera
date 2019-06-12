package com.demin.hera.Controller;

import com.demin.hera.Entity.Item;
import com.demin.hera.Service.ItemService;
import com.demin.hera.Util.Check;
import com.demin.hera.Util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/11 20:17;
 */
@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    ItemService service;

    @GetMapping("/findById")
    public Response findById(@RequestParam String id){
        Item item = service.getById(id);
        if(Check.isNotNull(item))
            return Response.createBySuccess(item);
        else
            return Response.createByError();
    }

    @PostMapping("/findAllByIds")
    public Response findAllByIds(@RequestBody List<String> ids){
        return Response.createBySuccess(service.getIdIn(ids));
    }

    public Response findAllByCateId(@RequestParam String categoryId,Integer limit){
        List<Item> items = service.getByCateId(categoryId,limit);
        return Response.createBySuccess(items);
    }
}
