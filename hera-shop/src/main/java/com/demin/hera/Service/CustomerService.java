package com.demin.hera.Service;

import com.demin.hera.Entity.Customer;
import com.demin.hera.Feign.CustomerFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by  Domain
 * on 2019/6/12 20:50;
 */
@Service
public class CustomerService {

    @Autowired
    CustomerFeign feign;
    public Customer getByName(String name){
        return feign.findByUsername(name);
    }

    public boolean pay(String customerId, BigDecimal payment){
        Customer customer = feign.findById(customerId);
        BigDecimal balance = customer.getBalance();
        if(customer.getBalance().compareTo(payment)>0){
            customer.setBalance(balance.subtract(payment));
            feign.save(customer);
            return true;
        }else
            return false;
    }

    public Customer getById(String customerId){
        return feign.findById(customerId);
    }
}
