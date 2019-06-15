package com.demin.hera.Feign;

import com.demin.hera.Entity.EsItem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/9 17:15;
 */
@FeignClient(value = "hera-base")
public interface ItemFeign {
    @RequestMapping("/item/findAll")
    List<EsItem> fetchItem();

    @RequestMapping("/item/findById")
    EsItem findById(@RequestParam("id")String id);
}
