package com.demin.hera.Feign;

import com.demin.hera.Entity.ItemOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/12 11:38;
 */
@FeignClient(value = "hera-base")
public interface ItemOrderFeign {
    @RequestMapping("/itemOrder/findById")
    ItemOrder findById(@RequestParam("id") String itemOrderId);

    @RequestMapping("/itemOrder/findAll")
    List<ItemOrder> findAll();

    @RequestMapping("/itemOrder/deleteById")
    void deleteById(@RequestParam("id") String itemOrderId);

    @RequestMapping(value = "/itemOrder/save",method = RequestMethod.POST)
    ItemOrder save(@RequestBody ItemOrder itemOrder);

    @RequestMapping("/itemOrder/existById")
    boolean existById(@RequestParam("id") String itemOrderId);

    @RequestMapping("/itemOrder/update")
    ItemOrder update(@RequestBody ItemOrder itemOrder);

    @RequestMapping("/itemOrder/findAllWithPage")
    Object findAllWithPage(@RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize);

    @RequestMapping("/itemOrder/findAllByOrderId")
    List<ItemOrder> findAllByOrderId(@RequestParam("orderId") String orderId);

}
