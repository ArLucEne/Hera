package com.demin.hera.Controller;

import com.demin.hera.Base.BaseController;
import com.demin.hera.Pojo.ItemCart;
import com.demin.hera.Service.ItemCartService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by  Domain
 * on 2019/6/10 21:15;
 */
@RestController
@RequestMapping("/itemCart")
public class ItemCartController  {

    @Autowired
    ItemCartService baseService;

    @GetMapping("/findById")
    ItemCart findByItemCartId(@RequestParam String id){
        return baseService.findByItemCartId(id);
    }
    @GetMapping("/findAll")
    List<ItemCart> findAll(){
        return baseService.findAll();
    }

    @PostMapping("/save")
    ItemCart save(@RequestBody ItemCart entity){
        return baseService.save(entity);
    }

    @GetMapping("/deleteById")
    void deleteById(@RequestParam String id){
        baseService.deleteById(id);
    }

    @PostMapping("/update")
    ItemCart update(@RequestBody ItemCart entity){
        return baseService.update(entity);
    }

    @GetMapping("/existById")
    boolean existById(@RequestParam String id){
        return baseService.existById(id);
    }

    @GetMapping("/findAllByItemIdAAndItemCartStatus")
    List<ItemCart> findAllByItemIdAAndItemCartStatus(@RequestParam String itemId,Integer status){
        return baseService.findAllByItemIdAAndItemCartStatus(itemId, status);
    }
    @GetMapping("/findAllByMemberNicknameAndItemCartStatus")
    List<ItemCart> findAllByMemberNicknameAndItemCartStatus(String name,Integer status){
        return baseService.findAllByMemberNicknameAndItemCartStatus(name, status);
    }
    @GetMapping("/findAllByMemberNicknameAndItemId")
    List<ItemCart> findAllByMemberNicknameAndItemId(String customerName,String itemId){
        return baseService.findAllByMemberNicknameAndItemId(customerName, itemId);
    }
}
