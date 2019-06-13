package com.demin.hera.Service;

import com.demin.hera.Entity.ItemOrder;
import com.demin.hera.Entity.Order;
import com.demin.hera.Feign.ItemOrderFeign;
import com.demin.hera.Feign.OrderFeign;
import com.demin.hera.Util.Check;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/12 11:35;
 */
@Service
public class OrderService {
    @Autowired
    OrderFeign orderFeign;

    @Autowired
    ItemOrderFeign itemOrderFeign;

    public List<Order> getByBuyerId(Long buyerId,Integer status){
        List<Order> orders = orderFeign.findAllByBuyerIdAndStatus(buyerId, status);
        for(Order order:orders){
            List<ItemOrder> itemOrders = itemOrderFeign.findAllByOrderId(order.getOrderId());
            order.setItemOrderList(itemOrders);
        }
        return orders;
    }

    public Order createOrder(Order order){
        order.setCreateTime(new Date());
        order.setStatus(OrderConstant.UN_PAID);

        List<ItemOrder> itemOrderList = order.getItemOrderList();
        for (ItemOrder itemOrder:itemOrderList) {
            itemOrder.setOrderId(order.getOrderId());
            itemOrderFeign.save(itemOrder);
        }
        return orderFeign.save(order);     //可能不成功
    }

    public boolean cancelOrder(String orderId){
        Order order = orderFeign.findById(orderId);
        order.setStatus(OrderConstant.CANCEL);
        return Check.isNotNull(orderFeign.save(order));
    }

    public boolean update(String orderId,Integer status){
        Order order = orderFeign.findById(orderId);
        if(Check.isNotNull(order)){
            order.setStatus(status);
            orderFeign.save(order);
            return true;
        }else
            return false;
    }


    public static class OrderConstant {

        public static final int CANCEL = 3;

        public static final int SUCCESS = 1;

        public static final int UN_PAID = 0;

    }
}
