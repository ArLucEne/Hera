package com.demin.hera.Service;

import com.demin.hera.Base.BaseService;
import com.demin.hera.Pojo.ItemSku;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/11 15:29;
 */
public interface ItemSkuService extends BaseService<ItemSku> {
    List<ItemSku> findAllByItemId(String itemId);
}
