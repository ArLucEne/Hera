package com.demin.hera.Service;

import com.demin.hera.Base.BaseService;
import com.demin.hera.Dao.ItemCategoryDao;
import com.demin.hera.Pojo.ItemCategory;
import com.demin.hera.Utils.updateEntity;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/4 17:07;
 */

public interface ItemCategoryService extends BaseService<ItemCategory> {
    public ItemCategory findByName(String name);

    List<ItemCategory> findAllByParentId(Long parentId);

    List<ItemCategory> findAllByRemark(String remark);
}
