package com.demin.hera.Service;

import com.demin.hera.Dao.AdminDao;
import com.demin.hera.Pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

/**
 * Created by  Domain
 * on 2019/6/4 16:51;
 */
@Service
public class AdminService {
    @Autowired
    AdminDao adminDao;

    @Cacheable(value = "adminCache")
    public Admin findById(String id){
        return adminDao.findById(id).get();
    }

    public Admin save(Admin admin){
        return adminDao.save(admin);
    }
}
