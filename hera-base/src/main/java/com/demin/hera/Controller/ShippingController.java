package com.demin.hera.Controller;

import com.demin.hera.Base.BaseController;
import com.demin.hera.Pojo.Shipping;
import com.demin.hera.Service.ShippingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by  Domain
 * on 2019/6/10 19:55;
 */
@RestController
@RequestMapping("/shipping")
public class ShippingController extends BaseController<Shipping, ShippingService> {

}
