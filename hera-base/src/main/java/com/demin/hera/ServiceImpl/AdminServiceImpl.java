package com.demin.hera.ServiceImpl;

import com.demin.hera.Base.BaseServiceImpl;
import com.demin.hera.Dao.AdminDao;
import com.demin.hera.Pojo.Admin;
import com.demin.hera.Service.AdminService;
import org.springframework.stereotype.Service;

/**
 * Created by  Domain
 * on 2019/6/10 21:07;
 */
@Service
public class AdminServiceImpl extends BaseServiceImpl<Admin, AdminDao> implements AdminService {
}
