package com.demin.hera.Service;

import com.demin.hera.Dao.CustomerDao;
import com.demin.hera.Pojo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

/**
 * Created by  Domain
 * on 2019/6/4 17:01;
 */
@Service
public class CustomerService {

    @Autowired
    CustomerDao customerDao;

    @Cacheable(value = "customerCache")
    public Customer findById(String id){
        return customerDao.findById(id).get();
    }

    public Customer save(Customer customer){
        return customerDao.save(customer);
    }
}
