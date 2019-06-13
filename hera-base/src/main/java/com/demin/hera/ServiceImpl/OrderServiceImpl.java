package com.demin.hera.ServiceImpl;

import com.demin.hera.Base.BaseServiceImpl;
import com.demin.hera.Dao.OrderDao;
import com.demin.hera.Pojo.Order;
import com.demin.hera.Service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/10 21:12;
 */
@Service
public class OrderServiceImpl extends BaseServiceImpl<Order, OrderDao> implements OrderService {
    @Override
    public boolean existById(String id){
        return super.baseDao.existsById(id);
    }

    @Override
    public List<Order> findAllByBuyerIdAndStatus(Long buyerId, Integer status) {
        return super.baseDao.findAllByBuyerIdAndStatus(buyerId, status);
    }


}
