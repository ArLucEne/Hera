package com.demin.hera.Service;

import com.demin.hera.Dao.ItemCategoryDao;
import com.demin.hera.Pojo.ItemCategory;
import com.demin.hera.Utils.updateEntity;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/4 17:07;
 */
@Service
public class ItemCategoryService {
    @Autowired
    ItemCategoryDao categoryDao;

    public List<ItemCategory> getAllWithPage(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        return categoryDao.findAll();
    }

    @Cacheable(value = "categoryCache")
    public ItemCategory findById(String id){
        return categoryDao.findById(id).get();
    }

    public ItemCategory save(ItemCategory category){
        return categoryDao.save(category);
    }

    public void deleteById(String id){
        categoryDao.deleteById(id);
    }

/*    public ItemCategory update(ItemCategory category){
        ItemCategory dest = categoryDao.findByName(category.getName());
        String oldId = dest.getCategoryId();
        updateEntity.update(category,dest);
        dest.setCategoryId(oldId);
        return categoryDao.save(dest);
    }*/
}
