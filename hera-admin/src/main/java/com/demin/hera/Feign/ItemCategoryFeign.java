package com.demin.hera.Feign;

import com.demin.hera.Entity.ItemCategory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/12 10:07;
 */
@FeignClient(value = "hera-base")
public interface ItemCategoryFeign {

    @GetMapping("/category/findById")
    ItemCategory findById(@RequestParam("id") String id);

    @RequestMapping("/category/findAll")
    List<ItemCategory> findAll();

    @RequestMapping("/category/deleteById")
    void deleteById(@RequestParam("id") String categoryId);

    @RequestMapping(value = "/category/save",method = RequestMethod.POST)
    ItemCategory save(@RequestBody ItemCategory category);

    @RequestMapping("/category/existById")
    boolean existById(@RequestParam("id") String categoryId);

    @RequestMapping("/category/update")
    ItemCategory update(@RequestBody ItemCategory category);

    @RequestMapping("/category/findAllWithPage")
    Object findAllWithPage(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize);



}
