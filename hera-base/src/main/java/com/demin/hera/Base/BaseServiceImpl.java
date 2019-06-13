package com.demin.hera.Base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Created by  Domain
 * on 2019/6/10 19:20;
 */
@Transactional
public class BaseServiceImpl<T,D extends BaseDao> implements BaseService<T>{
    @Autowired
    public D baseDao;

    @Override
    public List<T> findAll(){
        return baseDao.findAll();
    }

    @Override
    public PageInfo<T> findAllWithPage(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<T> items = baseDao.findAll();
        PageInfo<T> pageInfo = new PageInfo<>(items);
        return pageInfo;
    }

    @Override
    public void deleteById(String id){
        baseDao.deleteById(id);
    }

    @Override
    public Optional<T> findById(String id){
        return baseDao.findById(id);
    }

    @Override
    public T save(T t){
        return (T)baseDao.save(t);
    }

    @Override
    public T update(T t){
        return (T)baseDao.save(t);
    }

    @Override
    public boolean existById(String id) {
        return baseDao.existsById(id);
    }

}
