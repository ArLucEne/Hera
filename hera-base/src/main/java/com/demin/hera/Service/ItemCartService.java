package com.demin.hera.Service;

import com.demin.hera.Base.BaseService;
import com.demin.hera.Dao.ItemCartDao;
import com.demin.hera.Pojo.ItemCart;
import com.demin.hera.Pojo.ItemCategory;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Optional;

/**
 * Created by  Domain
 * on 2019/6/4 17:04;
 */

public interface ItemCartService   {

    List<ItemCart> findAll();

    ItemCart save(ItemCart entity);

    void deleteById(String id);

    ItemCart update(ItemCart entity);

    boolean existById(String id);

    ItemCart findByItemCartId(String id);

    List<ItemCart> findAllByItemIdAAndItemCartStatus(String itemId,Integer status);

    List<ItemCart> findAllByMemberNicknameAndItemCartStatus(String name,Integer status);

    List<ItemCart> findAllByMemberNicknameAndItemId(String customerName,String itemId);



}
