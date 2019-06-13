package com.demin.hera.Dao;

import com.demin.hera.Base.BaseDao;
import com.demin.hera.Pojo.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/4 12:50;
 */
@Repository
public interface OrderDao extends BaseDao<Order,String> {
    List<Order> findAllByBuyerIdAndStatus(Long buyerId,Integer status);
}
