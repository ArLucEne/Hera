package com.demin.hera.ServiceImpl;

import com.demin.hera.Base.BaseServiceImpl;
import com.demin.hera.Dao.CustomerDao;
import com.demin.hera.Pojo.Customer;
import com.demin.hera.Service.CustomerService;
import org.springframework.stereotype.Service;

/**
 * Created by  Domain
 * on 2019/6/10 21:08;
 */
@Service
public class CustomerServiceImpl extends BaseServiceImpl<Customer, CustomerDao> implements CustomerService {
}
