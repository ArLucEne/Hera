package com.demin.hera.Dao;

import com.demin.hera.Base.BaseDao;
import com.demin.hera.Pojo.ItemCart;
import com.github.pagehelper.PageInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by  Domain
 * on 2019/6/4 12:48;
 */
@Repository
public interface ItemCartDao extends JpaRepository<ItemCart,String> {


    ItemCart findByItemCartId(String id);

    List<ItemCart> findAllByItemIdAndItemCartStatus(String itemId,Integer status);

    List<ItemCart> findAllByMemberNicknameAndItemCartStatus(String name,Integer status);

    List<ItemCart> findAllByMemberNicknameAndItemCartId(String customerName,String itemCartId);
}
