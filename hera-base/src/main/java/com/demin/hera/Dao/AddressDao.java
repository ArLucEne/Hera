package com.demin.hera.Dao;

import com.demin.hera.Base.BaseDao;
import com.demin.hera.Pojo.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by  Domain
 * on 2019/6/4 12:45;
 */
@Repository
public interface AddressDao extends BaseDao<Address,String> {
}
