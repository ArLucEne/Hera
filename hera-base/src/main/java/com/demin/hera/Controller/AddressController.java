package com.demin.hera.Controller;

import com.demin.hera.Base.BaseController;
import com.demin.hera.Pojo.Address;
import com.demin.hera.Service.AddressService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by  Domain
 * on 2019/6/10 21:13;
 */
@RestController
@RequestMapping("/address")
public class AddressController extends BaseController<Address, AddressService> {
}
