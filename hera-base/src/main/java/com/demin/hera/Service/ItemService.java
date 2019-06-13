package com.demin.hera.Service;

import com.demin.hera.Base.BaseService;
import com.demin.hera.Dao.ItemDao;
import com.demin.hera.Pojo.Item;
import com.demin.hera.Utils.updateEntity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by  Domain
 * on 2019/6/4 17:03;
 */

public interface ItemService extends BaseService<Item> {
    public Item findByName(String name);

    List<Item> findAllByCId(Long cid);

}
