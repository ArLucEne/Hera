package com.demin.hera.Service;

import com.demin.hera.Dao.ItemDao;
import com.demin.hera.Pojo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


/**
 * Created by  Domain
 * on 2019/6/4 17:03;
 */
@Service
public class ItemService {
    @Autowired
    ItemDao itemDao;

    @Cacheable(value = "itemCache")
    public Item findById(String id){
        System.out.println("findById from SQL");
        Item item = itemDao.findById(id).get();
        return item;
    }

    public Item save(Item item){
        return itemDao.save(item);
    }
}
