package com.demin.hera.Service;

import com.demin.hera.Dao.ItemOrderDao;
import com.demin.hera.Pojo.ItemOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

/**
 * Created by  Domain
 * on 2019/6/4 17:09;
 */
@Service
public class ItemOrderService {
    @Autowired
    ItemOrderDao itemOrderDao;

    @Cacheable(value = "itemOrderCache")
    public ItemOrder findById(String id){
        return itemOrderDao.findById(id).get();
    }

    public ItemOrder save(ItemOrder itemOrder){
        return itemOrderDao.save(itemOrder);
    }
}
