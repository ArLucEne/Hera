package com.demin.hera.Service;

import com.demin.hera.Entity.Item;
import com.demin.hera.Entity.ItemCategory;
import com.demin.hera.Feign.ItemCategoryFeign;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/12 10:11;
 */
@Service
public class ItemCategoryService {

    @Autowired
    ItemCategoryFeign feign;

    @Autowired
    ItemService itemService;

    public List<List<ItemCategory>> getRootCat(Integer cateLimit,Integer itemLimit){
        return Lists.partition(getItemCatWithItemsByRemark("index", cateLimit, itemLimit), 2);
    }

    public List<ItemCategory> getItemCatWithItemsByRemark(String remark,Integer cateLimit,
                                                          Integer itemLimit){
        List<ItemCategory> results = feign.findAllByRemark(remark);
        List<ItemCategory> categories = new LinkedList<>();
        if (cateLimit<results.size()){
            for(int i=0;i<=cateLimit;i++)
                categories.add(results.get(i));
        }else
            categories=results;

        for(ItemCategory category:categories){
            List<Long> childrenId = getChildCateIds(category.getItemCatId());
            List<Item> items = itemService.getByCateIds(childrenId,itemLimit);
            category.setItems(items);
        }
        return categories;

    }

    public List<Long> getChildCateIds(Long parentId){
        List<ItemCategory> children = feign.findAllByParentId(parentId);
        List<Long> childrenIds = new LinkedList<>();
        for(ItemCategory category:children)
            childrenIds.add(category.getItemCatId());
        childrenIds.add(parentId);
        return childrenIds;
    }
}
