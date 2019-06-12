package com.demin.hera.Controller;

import com.demin.hera.Base.BaseController;
import com.demin.hera.Pojo.ItemSku;
import com.demin.hera.Service.ItemSkuService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by  Domain
 * on 2019/6/11 15:37;
 */
@RestController
@RequestMapping("/itemSku")
public class ItemSkuController extends BaseController<ItemSku, ItemSkuService> {
}
