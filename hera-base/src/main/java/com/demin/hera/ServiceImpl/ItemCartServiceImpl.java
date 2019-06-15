package com.demin.hera.ServiceImpl;

import com.demin.hera.Base.BaseServiceImpl;
import com.demin.hera.Dao.ItemCartDao;
import com.demin.hera.Pojo.ItemCart;
import com.demin.hera.Service.ItemCartService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/10 21:08;
 */
@Service
public class ItemCartServiceImpl implements ItemCartService {
    @Autowired
    ItemCartDao cartDao;

    @Override
    public List<ItemCart> findAll() {
        return cartDao.findAll();
    }



    @Override
    public ItemCart save(ItemCart entity) {
        return cartDao.save(entity);
    }

    @Override
    public void deleteById(String id) {
        cartDao.deleteById(id);
    }

    @Override
    public ItemCart update(ItemCart entity) {
        return cartDao.save(entity);
    }

    @Override
    public boolean existById(String id) {
        return cartDao.existsById(id);
    }

    @Override
    public ItemCart findByItemCartId(String id) {
        return cartDao.findByItemCartId(id);
    }

    @Override
    public List<ItemCart> findAllByItemIdAAndItemCartStatus(String itemId, Integer status) {
        return cartDao.findAllByItemIdAndItemCartStatus(itemId, status);
    }

    @Override
    public List<ItemCart> findAllByMemberNicknameAndItemCartStatus(String name, Integer status) {
        return cartDao.findAllByMemberNicknameAndItemCartStatus(name, status);
    }

    @Override
    public List<ItemCart> findAllByMemberNicknameAndItemId(String customerName, String itemId) {
        return cartDao.findAllByMemberNicknameAndItemCartId(customerName, itemId);
    }
}
