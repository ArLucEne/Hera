package com.demin.hera.Service;

import com.demin.hera.Entity.Item;
import com.demin.hera.Feign.ItemFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/11 19:58;
 */
@Service
public class ItemService {
    @Autowired
    ItemFeign feign;

    public Item getById(String itemId){
        return feign.findById(itemId);
    }

    public List<Item> getIdIn(List<String> itemIds){
        List<Item> result = new LinkedList<>();
        for(String itemId:itemIds)
            result.add(feign.findById(itemId));
        return result;
    }

    public List<Item> getByCateId(String cateId,Integer limit){
        List<Item> items = feign.findByCategoryId(cateId);
        List<Item> result = new LinkedList<>();
        if (items.size()>=limit){
            for(int i = 0;i<limit;i++)
                result.add(items.get(i));
            return result;
        }else
            return items;


    }

    public List<Item> findAll(){
        return feign.findAll();
    }
}
