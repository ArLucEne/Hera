package com.demin.hera.Service;

import com.demin.hera.Base.BaseService;
import com.demin.hera.Dao.CustomerDao;
import com.demin.hera.Pojo.Customer;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/4 17:01;
 */

public interface CustomerService  extends BaseService<Customer> {


}
