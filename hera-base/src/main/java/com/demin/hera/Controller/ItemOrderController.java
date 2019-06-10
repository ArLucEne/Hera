package com.demin.hera.Controller;

import com.demin.hera.Base.BaseController;
import com.demin.hera.Pojo.ItemOrder;
import com.demin.hera.Service.ItemOrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by  Domain
 * on 2019/6/10 21:16;
 */
@RequestMapping("/itemOrder")
@RestController
public class ItemOrderController extends BaseController<ItemOrder, ItemOrderService> {

}
