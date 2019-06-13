package com.demin.hera.Service;

import com.demin.hera.Base.BaseService;
import com.demin.hera.Dao.ItemCartDao;
import com.demin.hera.Pojo.ItemCart;
import com.demin.hera.Pojo.ItemCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/4 17:04;
 */

public interface ItemCartService  extends BaseService<ItemCart> {
    List<ItemCart> findAllByItemIdAAndItemCartStatus(String itemId,Integer status);

    List<ItemCart> findAllByMemberNicknameAndItemCartStatus(String name,Integer status);

    List<ItemCart> findAllByMemberNicknameAndItemId(String customerName,String itemId);



}
