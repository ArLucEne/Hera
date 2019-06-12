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

    @GetMapping("/findAllWithItemIdAndStatus")
    public List<ItemCart> findAllWithItemIdAndStatus(@RequestParam String itemId, int status) {
        return super.baseService.findAllWithItemIdAndStatus(itemId,status);
    }

    @GetMapping("/findAllByCustomerNameAndStatus")
    List<ItemCart> findAllByCustomerNameAndStatus(@RequestParam String customerName,int status){
        return super.baseService.findAllByCustomerNameAndStatus(customerName, status);
    }
    @GetMapping("/findAllByCustomerNameAndItemId")
    List<ItemCart> findAllByCustomerNameAndItemId(@RequestParam String customerName,String itemId){
        return super.baseService.findAllByCustomerNameAndItemId(customerName, itemId);
    }
}
