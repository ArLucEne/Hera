package com.demin.hera.ServiceImpl;

import com.demin.hera.Base.BaseServiceImpl;
import com.demin.hera.Dao.ItemSkuDao;
import com.demin.hera.Pojo.ItemSku;
import com.demin.hera.Service.ItemSkuService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/11 15:32;
 */
@Service
public class ItemSkuServiceImpl extends BaseServiceImpl<ItemSku, ItemSkuDao> implements ItemSkuService {
    @Override
    public List<ItemSku> findAllByItemId(String itemId) {
        return super.baseDao.findAllByItemId(itemId);
    }
}
