package com.demin.hera.Controller;

import com.demin.hera.Base.BaseController;
import com.demin.hera.Pojo.Item;
import com.demin.hera.Service.ItemService;
import com.demin.hera.Utils.Response;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/10 8:29;
 */
@RestController
@RequestMapping("/item")
public class ItemController extends BaseController<Item,ItemService> {

    @GetMapping("/existById")
    public boolean existById(@RequestParam String id){
        return super.baseService.existById(id);
    }

    @GetMapping("findAllByCategoryId")
    public List<Item> findByCategoryId(@RequestParam String categoryId){
        return super.baseService.findAllByCategoryId(categoryId);
    }
/*
    @Autowired
    ItemService itemService;


    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Item save(@RequestBody Item item){
        return itemService.save(item);
    }


    @RequestMapping("/findAll")
    public List<Item> findAll(){
        return itemService.findAll();
    }

    @RequestMapping("/findAllWithPage")
    public PageInfo<Item> findAllWithPage(@RequestParam int pageNum,@RequestParam int pageSize){
        return itemService.getAllWithPage(pageNum,pageSize);
    }

    @RequestMapping("/deleteById")
    public void deleteById(@RequestParam String itemId){
        itemService.deleteById(itemId);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Item update(@RequestBody Item item){
        return  itemService.update(item);
    }

    @RequestMapping("/findById")
    public Item findById(@RequestParam String itemId){
        return   itemService.findById(itemId);
    }

    @RequestMapping("/existById")
    public boolean existById(@RequestParam String itemId){
        return itemService.existById(itemId);
    }
*/

}
