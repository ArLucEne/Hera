package com.demin.hera.Base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

/**
 * Created by  Domain
 * on 2019/6/10 19:21;
 */
@NoRepositoryBean
public interface BaseDao<T,ID> extends JpaRepository<T,ID>, JpaSpecificationExecutor<T> {
}
