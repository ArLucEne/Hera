package com.demin.hera.Feign;

import com.demin.hera.Entity.ItemSku;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/12 9:35;
 */
@FeignClient("hera-base")
public interface ItemSkuFeign {

    @RequestMapping("/itemSku/finAllByItemId")
    List<ItemSku> findAllByItemId(@RequestParam("itemId") String itemId);
}
