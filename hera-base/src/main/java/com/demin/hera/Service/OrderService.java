package com.demin.hera.Service;

import com.demin.hera.Dao.OrderDao;
import com.demin.hera.Pojo.Order;
import com.github.pagehelper.PageHelper;
import net.sf.jsqlparser.expression.operators.conditional.OrExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/4 17:06;
 */
@Service
public class OrderService {
    @Autowired
    OrderDao orderDao;

    @Cacheable(value = "orderCache")
    public Order findById(String id){
        return orderDao.findById(id).get();
    }

    public Order save(Order order){
        return orderDao.save(order);
    }

    public void deleteId(String id){
        orderDao.deleteById(id);
    }

    public List<Order> getAllWithPage(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        return orderDao.findAll();
    }
}
