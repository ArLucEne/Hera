package com.demin.hera.Controller;

import com.demin.hera.Entity.ItemOrder;
import com.demin.hera.Entity.Order;
import com.demin.hera.Entity.Order;
import com.demin.hera.Entity.Response;
import com.demin.hera.Feign.ItemOrderFeign;
import com.demin.hera.Feign.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/14 8:52;
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderFeign feign;

    @Autowired
    ItemOrderFeign itemOrderFeign;

    @GetMapping("/findById")
    Response findById(@RequestParam String orderId){
        return Response.createBySuccess(feign.findById(orderId));
    }

    @GetMapping("/findAll")
    Response findAll(){
        List<Order> orderList = feign.findAll();
        for(Order order: orderList){
                List<ItemOrder> itemOrders = itemOrderFeign.findAllByOrderId(order.getOrderId());
                order.setItemOrderList(itemOrders);
        }
        return Response.createBySuccess(orderList);
    }

    @GetMapping("/deleteById")
    Response deleteById(@RequestParam String orderId){
        feign.deleteById(orderId);
        return Response.createBySuccess();
    }

    @PostMapping(value = "/save")
    Response save(@RequestBody Order order){
        return Response.createBySuccess(feign.save(order));
    }

    @GetMapping("/existById")
    Response existById(@RequestParam String orderId){
        return Response.createBySuccess(feign.existById(orderId));
    }

    @PostMapping("/update")
    Response update(@RequestBody Order order){
        return Response.createBySuccess(feign.update(order));
    }

    @GetMapping("/findAllWithPage")
    Response findAllWithPage(@RequestParam int pageNum, @RequestParam int pageSize){
        return Response.createBySuccess(feign.findAllWithPage(pageNum,pageSize));
    }
}
