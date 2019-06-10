package com.demin.hera.Dao;

import com.demin.hera.Base.BaseDao;
import com.demin.hera.Pojo.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by  Domain
 * on 2019/6/4 12:47;
 */
@Repository
public interface CustomerDao extends BaseDao<Customer,String> {
    public Customer findByName(String name);
}
