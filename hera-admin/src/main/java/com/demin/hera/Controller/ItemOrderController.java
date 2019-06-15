package com.demin.hera.Controller;

import com.demin.hera.Entity.ItemOrder;
import com.demin.hera.Entity.Response;
import com.demin.hera.Feign.ItemOrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by  Domain
 * on 2019/6/14 8:54;
 */
@RestController
@RequestMapping("/itemOrder")
public class ItemOrderController {

    @Autowired
    ItemOrderFeign feign;

    @GetMapping("/findById")
    Response findById(@RequestParam String id){
        return Response.createBySuccess(feign.findById(id));
    }

    @GetMapping("/findAll")
    Response findAll(){
        return Response.createBySuccess(feign.findAll());
    }

    @GetMapping("/deleteById")
    Response deleteById(@RequestParam String id){
        feign.deleteById(id);
        return Response.createBySuccess();
    }

    @PostMapping(value = "/save")
    Response save(@RequestBody ItemOrder itemOrder){
        return Response.createBySuccess(feign.save(itemOrder));
    }

    @GetMapping("/existById")
    Response existById(@RequestParam String id){
        return Response.createBySuccess(feign.existById(id));
    }

    @PostMapping("/update")
    Response update(@RequestBody ItemOrder itemOrder){
        return Response.createBySuccess(feign.update(itemOrder));
    }

    @GetMapping("/findAllWithPage")
    Response findAllWithPage(@RequestParam int pageNum, @RequestParam int pageSize){
        return Response.createBySuccess(feign.findAllWithPage(pageNum,pageSize));
    }
}
