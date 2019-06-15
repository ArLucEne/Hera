package com.demin.hera.Service;

import com.demin.hera.Entity.ItemCart;
import com.demin.hera.Feign.ItemCartFeign;
import com.demin.hera.Util.Check;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by  Domain
 * on 2019/6/11 16:25;
 */
@Service
public class ItemCartService {

    @Autowired
    ItemCartFeign feign;

    public boolean add(ItemCart itemCart){
        List<ItemCart> result = feign.findAllByItemIdAAndItemCartStatus(itemCart.getItemId(),0);
        if (result.isEmpty()){      //新增某item的购物车记录
            itemCart.setItemCartId(UUID.randomUUID().toString().replaceAll("-",""));
            itemCart.setCreateDate(new Date());
            itemCart.setItemCartStatus(0);
            return Check.isNotNull(feign.save(itemCart));
        }else {
            ItemCart cart = result.get(0);
            itemCart.setItemCartId(cart.getItemCartId());
            itemCart.setModifyDate(new Date());
            itemCart.setItemCartStatus(0);
            itemCart.setQuantity(cart.getQuantity()+itemCart.getQuantity());
            return Check.isNotNull(feign.save(itemCart));
        }
    }

    public List<ItemCart> list(String customerName){
        return feign.findAllByMemberNicknameAndItemCartStatus(customerName,0);
    }

    public boolean updateNum(String customerName,String itemId,int num){
        List<ItemCart> result = feign.findAllByMemberNicknameAndItemId(customerName,itemId);
        ItemCart itemCart = result.get(0);
        if(itemCart.getQuantity()!=num){
            itemCart.setQuantity(num);
            return Check.isNotNull(feign.save(itemCart));
        }
        return false;
    }

    public boolean submitOrder(String itemCartId){
        ItemCart itemCart = feign.findById(itemCartId);
        if(itemCart!=null){
            itemCart.setItemCartStatus(1);
            Check.isNotNull(feign.save(itemCart));
        }
        return false;
    }

    public boolean submitOrder(List<String> itemCartIds){
        try{
            boolean flag = true;
            for(String id:itemCartIds){
                ItemCart temp = feign.findById(id);
                temp.setItemCartStatus(1);      //提交为1状态，未提及为0状态
                flag = Check.isNotNull(feign.save(temp));
            }
            return flag;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean clear(String customerName){
        List<ItemCart> itemCarts = feign.findAllByMemberNicknameAndItemCartStatus(customerName,0);
        itemCarts.forEach(itemCart -> {
            itemCart.setItemCartStatus(2);
            feign.save(itemCart);
        });       //删除为2状态
        return true;
    }

    public boolean delete(String customerName,String itemCartId) {
        List<ItemCart> itemCarts = feign.findAllByMemberNicknameAndItemId(customerName, itemCartId);
        ItemCart result = itemCarts.get(0);
        result.setItemCartStatus(2);
        return Check.isNotNull(feign.save(result));
    }
}
