package com.demin.hera.ServiceImpl;

import com.demin.hera.Base.BaseServiceImpl;
import com.demin.hera.Dao.ItemOrderDao;
import com.demin.hera.Pojo.ItemOrder;
import com.demin.hera.Service.ItemOrderService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/10 21:10;
 */
@Service
public class ItemOrderServiceImpl extends BaseServiceImpl<ItemOrder, ItemOrderDao> implements ItemOrderService {
    @Override
    public List<ItemOrder> findAllByOrderId(String orderId) {
        return super.baseDao.findAllByOrderId(orderId);
    }
}
