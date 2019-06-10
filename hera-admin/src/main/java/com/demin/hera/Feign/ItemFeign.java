package com.demin.hera.Feign;

import com.demin.hera.Entity.Item;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/10 8:59;
 */
@FeignClient(value = "hera-base")
public interface ItemFeign {
    /**
     * @RequestParam中的参数必须填写，否则报错！！
     * @param itemId
     * @return
     */
    @RequestMapping("/item/findById")
    Item findById(@RequestParam("id") String itemId);

    @RequestMapping("/item/findAll")
     List<Item> findAll();

    @RequestMapping("/item/deleteById")
    void deleteById(@RequestParam("id") String itemId);

    @RequestMapping(value = "/item/save",method = RequestMethod.POST)
    Item save(@RequestBody Item item);

    @RequestMapping("/item/existById")
    boolean existById(@RequestParam("id") String itemId);

    @RequestMapping("/item/update")
    Item update(@RequestBody Item item);

    @RequestMapping("/item/findAllWithPage")
    Object findAllWithPage(@RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize);
}
