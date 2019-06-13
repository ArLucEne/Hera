package com.demin.hera.Dao;

import com.demin.hera.Base.BaseDao;
import com.demin.hera.Pojo.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/4 12:47;
 */
@Repository
public interface ItemDao extends BaseDao<Item,String> {
    public Item findByName(String name);

    List<Item> findAllByCId(Long cid);

}
