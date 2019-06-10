package com.demin.hera.Controller;

import com.demin.hera.Pojo.ItemCategory;
import com.demin.hera.Service.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/10 8:32;
 */
/*@RestController
@RequestMapping("/category")
public class ItemCategoryController {
    @Autowired
    ItemCategoryService service;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ItemCategory save(@RequestBody ItemCategory ItemCategory){
       return service.save(ItemCategory);
    }

    @RequestMapping("/findAll")
    public List<ItemCategory> getAll(){
        return service.findAll();

    }

    @RequestMapping("/deleteById")
    public void deleteById(@RequestParam String itemId){
        service.deleteById(itemId);
    }

    @RequestMapping("/findById")
    public ItemCategory findById(@RequestParam String categoryId){
        return service.findById(categoryId);
    }
}*/
