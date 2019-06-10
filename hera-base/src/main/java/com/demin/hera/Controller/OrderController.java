package com.demin.hera.Controller;

import com.demin.hera.Base.BaseController;
import com.demin.hera.Pojo.Order;
import com.demin.hera.Service.OrderService;
import com.demin.hera.Utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/10 8:34;
 */
@RestController
@RequestMapping("/order")
public class OrderController extends BaseController<Order,OrderService> {

    @GetMapping("/existById")
    public boolean existById(@RequestParam String id){
        return super.baseService.existById(id);
    }


}
