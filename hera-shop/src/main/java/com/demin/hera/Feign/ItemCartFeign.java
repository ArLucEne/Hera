package com.demin.hera.Feign;

import com.demin.hera.Entity.ItemCart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/11 16:18;
 */
@FeignClient(value = "hera-base")
public interface ItemCartFeign {
    @RequestMapping("/itemCart/findById")
    ItemCart findById(@RequestParam("id") String itemCartId);

    @RequestMapping("/itemCart/findAll")
    List<ItemCart> findAll();

    @RequestMapping("/itemCart/deleteById")
    void deleteById(@RequestParam("id") String itemCartId);

    @RequestMapping(value = "/itemCart/save",method = RequestMethod.POST)
    ItemCart save(@RequestBody ItemCart ItemCart);

    @RequestMapping("/itemCart/existById")
    boolean existById(@RequestParam("id") String itemCartId);

    @RequestMapping("/itemCart/update")
    ItemCart update(@RequestBody ItemCart ItemCart);

    @RequestMapping("/itemCart/findAllWithPage")
    Object findAllWithPage(@RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize);

    @RequestMapping("/itemCart/findAllWithItemIdAndStatus")
    List<ItemCart> findAllWithItemIdAndStatus(@RequestParam("itemId")String itemId,@RequestParam("status") int status);

    @RequestMapping("/itemCart/findAllByCustomerNameAndStatus")
    List<ItemCart> findAllByCustomerNameAndStatus(@RequestParam("customerName") String customerName,@RequestParam("status") int status);

    @RequestMapping("/itemCart/findAllByCustomerNameAndItemId")
    List<ItemCart> findAllByCustomerNameAndItemId(@RequestParam("customerName") String customerName,@RequestParam("itemId") String itemId);
}
