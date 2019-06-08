package com.demin.hera.Controller;

import com.demin.hera.Pojo.Order;
import com.demin.hera.Service.OrderService;
import com.demin.hera.Utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/8 21:35;
 */
@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService service;

    @RequestMapping("/getAll")
    public Response getAll(@RequestParam int pageNum,@RequestParam int pageSize){
        List orderList = service.getAllWithPage(pageNum,pageSize);
        if(orderList.isEmpty())
            return Response.createByError();
        else
            return Response.createBySuccess(orderList);
    }

    @RequestMapping("/findById")
    public Response findById(@RequestParam String orderId){
        Order result = service.findById(orderId);
        if(result != null)
            return Response.createBySuccess(result);
        else
            return Response.createByError();
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Response save(@RequestBody Order order){
        return Response.createBySuccess(service.save(order));
    }

    @RequestMapping("deleteById")
    public Response deleteById(@RequestParam String orderId){
        service.deleteId(orderId);
        if(service.findById(orderId) == null)
            return Response.createBySuccess();
        else
            return Response.createByError();
    }
}
