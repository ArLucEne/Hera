package com.demin.hera.Dao;

import com.demin.hera.Base.BaseDao;
import com.demin.hera.Pojo.ItemOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/4 12:49;
 */
@Repository
public interface ItemOrderDao extends BaseDao<ItemOrder,String> {
    List<ItemOrder> findAllByOrderId(String orderId);
}
