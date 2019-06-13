package com.demin.hera.ServiceImpl;

import com.demin.hera.Base.BaseServiceImpl;
import com.demin.hera.Dao.ItemCartDao;
import com.demin.hera.Pojo.ItemCart;
import com.demin.hera.Service.ItemCartService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/10 21:08;
 */
@Service
public class ItemCartServiceImpl extends BaseServiceImpl<ItemCart, ItemCartDao > implements ItemCartService {


    @Override
    public List<ItemCart> findAllByItemIdAAndItemCartStatus(String itemId, Integer status) {
        return super.baseDao.findAllByItemIdAAndItemCartStatus(itemId, status);
    }

    @Override
    public List<ItemCart> findAllByMemberNicknameAndItemCartStatus(String name, Integer status) {
        return super.baseDao.findAllByMemberNicknameAndItemCartStatus(name, status);
    }

    @Override
    public List<ItemCart> findAllByMemberNicknameAndItemId(String customerName, String itemId) {
        return super.baseDao.findAllByMemberNicknameAndItemId(customerName, itemId);
    }
}
