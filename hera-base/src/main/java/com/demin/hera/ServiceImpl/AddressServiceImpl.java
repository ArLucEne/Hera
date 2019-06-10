package com.demin.hera.ServiceImpl;

import com.demin.hera.Base.BaseServiceImpl;
import com.demin.hera.Dao.AddressDao;
import com.demin.hera.Pojo.Address;
import com.demin.hera.Service.AddressService;
import org.springframework.stereotype.Service;

/**
 * Created by  Domain
 * on 2019/6/10 21:06;
 */
@Service
public class AddressServiceImpl extends BaseServiceImpl<Address, AddressDao> implements AddressService {
}
