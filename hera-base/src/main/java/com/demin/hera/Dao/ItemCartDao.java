package com.demin.hera.Dao;

import com.demin.hera.Pojo.ItemCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by  Domain
 * on 2019/6/4 12:48;
 */
@Repository
public interface ItemCartDao extends JpaRepository<ItemCart,Integer> {
}