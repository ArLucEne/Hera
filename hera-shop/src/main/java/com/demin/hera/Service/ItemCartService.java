package com.demin.hera.Service;

import com.demin.hera.Entity.ItemCart;
import com.demin.hera.Feign.ItemCartFeign;
import com.demin.hera.Util.Check;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/11 16:25;
 */
@Service
public class ItemCartService {

    @Autowired
    ItemCartFeign feign;

    public boolean add(ItemCart itemCart){
        List<ItemCart> result = feign.findAllWithItemIdAndStatus(itemCart.getItemId(),0);
        if (result.isEmpty()){      //新增某item的购物车记录
            itemCart.setCreateTime(LocalDateTime.now());
            itemCart.setStatus(0);
            return Check.isNotNull(feign.save(itemCart));
        }else {
            ItemCart cart = result.get(0);
            itemCart.setCartId(cart.getCartId());
            itemCart.setModifyTime(LocalDateTime.now());
            itemCart.setItemNum(cart.getItemNum()+itemCart.getItemNum());
            return Check.isNotNull(feign.save(itemCart));
        }
    }

    public List<ItemCart> list(String customerName){
        return feign.findAllByCustomerNameAndStatus(customerName,0);
    }

    public boolean updateNum(String customerName,String itemId,int num){
        List<ItemCart> result = feign.findAllByCustomerNameAndItemId(customerName,itemId);
        ItemCart itemCart = result.get(0);
        if(itemCart.getItemNum()!=num){
            itemCart.setItemNum(num);
            return Check.isNotNull(feign.save(itemCart));
        }
        return false;
    }

    public boolean submitOrder(String itemCartId){
        ItemCart itemCart = feign.findById(itemCartId);
        if(itemCart!=null){
            itemCart.setStatus(1);
            Check.isNotNull(feign.save(itemCart));
        }
        return false;
    }

    public boolean submitOrder(List<String> itemCartIds){
        try{
            boolean flag = true;
            for(String id:itemCartIds){
                ItemCart temp = feign.findById(id);
                temp.setStatus(1);      //提交为1状态，未提及为0状态
                flag = Check.isNotNull(feign.save(temp));
            }
            return flag;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean clear(String customerName){
        List<ItemCart> itemCarts = feign.findAllByCustomerNameAndStatus(customerName,0);
        itemCarts.forEach(itemCart -> {
            itemCart.setStatus(2);
            feign.save(itemCart);
        });       //删除为2状态
        return true;
    }

    public boolean delete(String customerName,String itemId) {
        List<ItemCart> itemCarts = feign.findAllByCustomerNameAndItemId(customerName, itemId);
        ItemCart result = itemCarts.get(0);
        result.setStatus(2);
        return Check.isNotNull(feign.save(result));
    }
}
