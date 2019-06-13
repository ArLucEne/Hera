package com.demin.hera.Feign;

import com.demin.hera.Entity.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/12 11:32;
 */
@FeignClient(value = "hera-base")
public interface OrderFeign {
    @RequestMapping("/order/findById")
    Order findById(@RequestParam("id") String orderId);

    @RequestMapping("/order/findAll")
    List<Order> findAll();

    @RequestMapping("/order/deleteById")
    void deleteById(@RequestParam("id") String orderId);

    @RequestMapping(value = "/order/save",method = RequestMethod.POST)
    Order save(@RequestBody Order order);

    @RequestMapping("/order/existById")
    boolean existById(@RequestParam("id") String orderId);

    @RequestMapping("/order/update")
    Order update(@RequestBody Order order);

    @RequestMapping("/order/findAllWithPage")
    Object findAllWithPage(@RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize);

    @RequestMapping("/findAllByBuyerIdAndStatus")
    List<Order> findAllByBuyerIdAndStatus(@RequestParam("buyerId") Long buyerId, @RequestParam("status") Integer status);
}
