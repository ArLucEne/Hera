package com.demin.hera.Feign;

import com.demin.hera.Entity.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/12 20:48;
 */
@FeignClient(value = "hera-base")
public interface CustomerFeign {
    @RequestMapping("/customer/findById")
    Customer findById(@RequestParam("id") String customerId);

    @RequestMapping("/customer/findAll")
    List<Customer> findAll();

    @RequestMapping("/customer/deleteById")
    void deleteById(@RequestParam("id") String customerId);

    @RequestMapping(value = "/customer/save",method = RequestMethod.POST)
    Customer save(@RequestBody Customer Customer);

    @RequestMapping("/customer/existById")
    boolean existById(@RequestParam("id") String customerId);

    @RequestMapping("/customer/update")
    Customer update(@RequestBody Customer Customer);

    @RequestMapping("/customer/findAllWithPage")
    Object findAllWithPage(@RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize);


    @RequestMapping("/customer/findByUsername")
    Customer findByUsername(@RequestParam("name") String name);
}
