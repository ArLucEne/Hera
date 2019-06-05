package com.demin.hera.Service;

import com.demin.hera.Dao.ItemCategoryDao;
import com.demin.hera.Pojo.ItemCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

/**
 * Created by  Domain
 * on 2019/6/4 17:07;
 */
@Service
public class ItemCategoryService {
    @Autowired
    ItemCategoryDao categoryDao;

    @Cacheable(value = "categoryCache")
    public ItemCategory findById(String id){
        return categoryDao.findById(id).get();
    }

    public ItemCategory save(ItemCategory category){
        return categoryDao.save(category);
    }
}
