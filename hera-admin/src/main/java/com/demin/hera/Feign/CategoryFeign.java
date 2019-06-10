package com.demin.hera.Feign;

import com.demin.hera.Entity.ItemCategory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/10 13:46;
 */
@FeignClient(value = "hera-base")
public interface CategoryFeign {
    @RequestMapping("/category/findAll")
    List<ItemCategory> findAll();
}
