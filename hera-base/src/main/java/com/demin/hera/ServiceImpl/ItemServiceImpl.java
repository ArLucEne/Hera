package com.demin.hera.ServiceImpl;

import com.demin.hera.Base.BaseServiceImpl;
import com.demin.hera.Dao.ItemDao;
import com.demin.hera.Pojo.Item;
import com.demin.hera.Service.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/10 21:24;
 */
@Service
public class ItemServiceImpl extends BaseServiceImpl<Item, ItemDao> implements ItemService {
    @Override
    public boolean existById(String id){
        return super.baseDao.existsById(id);
    }


    @Override
    public Item findByName(String name) {
        return super.baseDao.findByName(name);
    }

    @Override
    public List<Item> findAllByCId(Long cid) {
        return super.baseDao.findAllByCId(cid);
    }
}
