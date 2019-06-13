package com.demin.hera.ServiceImpl;

import com.demin.hera.Base.BaseServiceImpl;
import com.demin.hera.Dao.ItemCategoryDao;
import com.demin.hera.Pojo.ItemCategory;
import com.demin.hera.Service.ItemCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/10 21:09;
 */
@Service
public class ItemCategoryServiceImpl extends BaseServiceImpl<ItemCategory, ItemCategoryDao> implements ItemCategoryService {


    @Override
    public ItemCategory findByName(String name) {
        return super.baseDao.findByName(name);
    }

    @Override
    public List<ItemCategory> findAllByParentId(Long parentId) {
        return super.baseDao.findAllByParentId(parentId);
    }

    @Override
    public List<ItemCategory> findAllByRemark(String remark) {
        return super.baseDao.findAllByRemark(remark);
    }
}
