package com.demin.hera.Service;

import com.demin.hera.Dao.ItemCartDao;
import com.demin.hera.Pojo.ItemCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

/**
 * Created by  Domain
 * on 2019/6/4 17:04;
 */
@Service
public class ItemCartService {
    @Autowired
    ItemCartDao cartDao;

    @Cacheable(value = "itemCartCache")
    public ItemCart findById(Integer id){
        return cartDao.findById(id).get();
    }

    public ItemCart save(ItemCart itemCart){
        return cartDao.save(itemCart);
    }
}
