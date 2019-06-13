package com.demin.hera.Service;

import com.demin.hera.Base.BaseService;
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

public interface OrderService extends BaseService<Order> {
    boolean existById(String id);

    List<Order> findAllByBuyerIdAndStatus(Long buyerId,Integer status);

}
