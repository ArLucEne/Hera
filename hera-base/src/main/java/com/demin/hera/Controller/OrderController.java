package com.demin.hera.Controller;

import com.demin.hera.Pojo.Order;
import com.demin.hera.Service.OrderService;
import com.demin.hera.Utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/10 8:34;
 */
/*
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService service;

    @RequestMapping("/findAll")
    public List<Order> findAll(){
        return service.findAll();
    }

    @RequestMapping("/findById")
    public Order findById(@RequestParam String orderId){
        return service.findById(orderId);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Order save(@RequestBody Order order){
        return service.save(order);
    }

    @RequestMapping("deleteById")
    public void deleteById(@RequestParam String orderId) {
        service.deleteById(orderId);
    }
}
*/
