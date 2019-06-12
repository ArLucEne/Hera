package com.demin.hera.Dao;

import com.demin.hera.Base.BaseDao;
import com.demin.hera.Pojo.ItemCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/4 12:48;
 */
@Repository
public interface ItemCartDao extends BaseDao<ItemCart,String> {
    List<ItemCart> findAllByItemIdAndStatus(String itemId,int status);

    List<ItemCart> findAllByCustomerNameAndStatus(String customerName,int status);

    List<ItemCart> findAllByCustomerNameAndItemId(String customerName,String itemId);
}
