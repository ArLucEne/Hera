package com.demin.hera.Service;

import com.demin.hera.Dao.OrderDao;
import com.demin.hera.Pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

/**
 * Created by  Domain
 * on 2019/6/4 17:06;
 */
@Service
public class OrderService {
    @Autowired
    OrderDao orderDao;

    @Cacheable(value = "orderCache")
    public Order findById(Integer id){
        return orderDao.findById(id).get();
    }

    public Order save(Order order){
        return orderDao.save(order);
    }
}
