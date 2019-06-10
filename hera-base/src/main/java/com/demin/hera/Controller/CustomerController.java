package com.demin.hera.Controller;

import com.demin.hera.Base.BaseController;
import com.demin.hera.Pojo.Customer;
import com.demin.hera.Service.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by  Domain
 * on 2019/6/10 21:14;
 */
@RestController
@RequestMapping("/customer")
public class CustomerController extends BaseController<Customer, CustomerService> {
}
