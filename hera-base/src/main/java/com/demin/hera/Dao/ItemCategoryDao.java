package com.demin.hera.Dao;

import com.demin.hera.Base.BaseDao;
import com.demin.hera.Pojo.ItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/4 12:49;
 */
@Repository
public interface ItemCategoryDao extends BaseDao<ItemCategory,String> {
    public ItemCategory findByName(String name);

    List<ItemCategory> findAllByParentId(String parentId);

    List<ItemCategory> findAllByRemark(String remark);

}
