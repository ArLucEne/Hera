package com.demin.hera.Controller;

import com.demin.hera.Entity.ItemCart;
import com.demin.hera.Service.ItemCartService;
import com.demin.hera.Util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/11 19:02;
 */
@RestController
@RequestMapping("/cart")
public class ItemCartController {
    @Autowired
    ItemCartService service;

    @PostMapping("/add")
    public Response add(@RequestBody ItemCart itemCart){
        if(service.add(itemCart))
            return Response.createBySuccess();
        else
            return Response.createByErrorMessage("添加商品到购物车失败");
    }
    @GetMapping("/list")
    public Response list(@RequestParam String customerName){
        return Response.createBySuccess(service.list(customerName));
    }

    @GetMapping("/updateNum")
    public Response updateNum(@RequestParam String customerName,String itemId,int num){
        if (service.updateNum(customerName, itemId, num))
            return Response.createBySuccess();
        else
            return Response.createByErrorMessage("更新商品数量失败");
    }
    @GetMapping("/clear")
    public Response clear(@RequestParam String customerName){
        if (service.clear(customerName))
            return Response.createBySuccess();
        else
            return Response.createByErrorMessage("清空购物车失败");
    }

    @GetMapping("/delete")
    public Response delete(@RequestParam String customerName,String itemId){
        if (service.delete(customerName, itemId))
            return Response.createBySuccess();
        else
            return Response.createByErrorMessage("删除失败");
    }

    @PostMapping("/submit")
    public Response submitOrder(@RequestBody List<String> itemCartIds){
        if (service.submitOrder(itemCartIds))
            return Response.createBySuccess();
        else
            return Response.createByErrorMessage("提交订单失败");
    }

}
