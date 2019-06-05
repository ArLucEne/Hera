package com.demin.hera.Dao;

import com.demin.hera.Pojo.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by  Domain
 * on 2019/6/4 12:50;
 */
@Repository
public interface ShippingDao extends JpaRepository<Shipping,Integer> {
}
