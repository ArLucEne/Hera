package com.demin.hera.Base;

import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Optional;

/**
 * Created by  Domain
 * on 2019/6/10 20:20;
 */
public interface BaseService<T> {
    List<T> findAll();

    PageInfo<T> findAllWithPage(int pageNum,int pageSize);

    Optional<T> findById(String id);

    T save(T entity);

    void deleteById(String id);

    T update(T entity);

    boolean existById(String id);
}
