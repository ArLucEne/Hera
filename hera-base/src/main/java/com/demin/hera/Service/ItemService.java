package com.demin.hera.Service;

import com.demin.hera.Dao.ItemDao;
import com.demin.hera.Pojo.Item;
import com.demin.hera.Utils.updateEntity;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


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


    public List<Item> getAllWithPage(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        return itemDao.findAll();
    }

    public void deleteById(String itemId){
        itemDao.deleteById(itemId);
    }

    public Item save(Item item){
        return itemDao.save(item);
    }

    public Item update(Item item){
        Item dest = itemDao.findByName(item.getName());
        String oldId = dest.getItemId();
        updateEntity.update(item,dest);
        dest.setItemId(oldId);
        return itemDao.save(dest);
    }

}
