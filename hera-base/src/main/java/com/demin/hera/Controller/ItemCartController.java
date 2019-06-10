package com.demin.hera.Controller;

import com.demin.hera.Base.BaseController;
import com.demin.hera.Pojo.ItemCart;
import com.demin.hera.Service.ItemCartService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by  Domain
 * on 2019/6/10 21:15;
 */
@RestController
@RequestMapping("/itemCart")
public class ItemCartController extends BaseController<ItemCart, ItemCartService> {
}
