package com.demin.hera.Controller;

import com.demin.hera.Base.BaseController;
import com.demin.hera.Pojo.ItemOrder;
import com.demin.hera.Service.ItemOrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/10 21:16;
 */
@RequestMapping("/itemOrder")
@RestController
public class ItemOrderController extends BaseController<ItemOrder, ItemOrderService> {

    @GetMapping("/findAllByOrderId")
    List<ItemOrder> findAllByOrderId(@RequestParam String orderId){
        return super.baseService.findAllByOrderId(orderId);
    }

}
