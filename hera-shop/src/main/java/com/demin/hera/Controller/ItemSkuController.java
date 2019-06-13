package com.demin.hera.Controller;

import com.demin.hera.Service.ItemSkuService;
import com.demin.hera.Util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by  Domain
 * on 2019/6/12 9:49;
 */
@RestController
@RequestMapping("/itemSku")
public class ItemSkuController {
    @Autowired
    ItemSkuService skuService;

    @GetMapping("/list")
    public Response getItemInfo(@RequestParam String itemId){
        return Response.createBySuccess(skuService.getItemInfo(itemId));
    }
}
