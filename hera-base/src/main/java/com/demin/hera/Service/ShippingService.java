package com.demin.hera.Service;

import com.demin.hera.Dao.ShippingDao;
import com.demin.hera.Pojo.Shipping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

/**
 * Created by  Domain
 * on 2019/6/4 17:10;
 */
@Service
public class ShippingService {
    @Autowired
    ShippingDao shippingDao;

    @Cacheable(value = "shippingCache")
    public Shipping findById(String id){
        return shippingDao.findById(id).get();
    }

    public Shipping save(Shipping shipping){
        return  shippingDao.save(shipping);
    }
}
