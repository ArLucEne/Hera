package com.demin.hera.Controller;

import com.demin.hera.Base.BaseController;
import com.demin.hera.Pojo.ItemCart;
import com.demin.hera.Service.ItemCartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/10 21:15;
 */
@RestController
@RequestMapping("/itemCart")
public class ItemCartController extends BaseController<ItemCart, ItemCartService> {

    @GetMapping("/findAllByItemIdAAndItemCartStatus")
    List<ItemCart> findAllByItemIdAAndItemCartStatus(@RequestParam String itemId,Integer status){
        return super.baseService.findAllByItemIdAAndItemCartStatus(itemId, status);
    }
    @GetMapping("/findAllByMemberNicknameAndItemCartStatus")
    List<ItemCart> findAllByMemberNicknameAndItemCartStatus(String name,Integer status){
        return super.baseService.findAllByMemberNicknameAndItemCartStatus(name, status);
    }
    @GetMapping("/findAllByMemberNicknameAndItemId")
    List<ItemCart> findAllByMemberNicknameAndItemId(String customerName,String itemId){
        return super.baseService.findAllByMemberNicknameAndItemId(customerName, itemId);
    }
}
