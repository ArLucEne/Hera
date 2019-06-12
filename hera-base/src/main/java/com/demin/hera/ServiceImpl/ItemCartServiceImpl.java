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
    public List<ItemCart> findAllWithItemIdAndStatus(String itemId, int status) {
        return super.baseDao.findAllByItemIdAndStatus(itemId,status);
    }

    @Override
    public List<ItemCart> findAllByCustomerNameAndStatus(String customerName, int status) {
        return super.baseDao.findAllByCustomerNameAndStatus(customerName,status);
    }

    @Override
    public List<ItemCart> findAllByCustomerNameAndItemId(String customerName, String itemId) {
        return super.baseDao.findAllByCustomerNameAndItemId(customerName,itemId);
    }
}
