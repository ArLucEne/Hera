package com.demin.hera.Service;

import com.demin.hera.Base.BaseService;
import com.demin.hera.Dao.ItemCartDao;
import com.demin.hera.Pojo.ItemCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/4 17:04;
 */

public interface ItemCartService  extends BaseService<ItemCart> {
    List<ItemCart> findAllWithItemIdAndStatus(String itemId,int status);

    List<ItemCart> findAllByCustomerNameAndStatus(String customerName,int status);

    List<ItemCart> findAllByCustomerNameAndItemId(String customerName,String itemId);

}
