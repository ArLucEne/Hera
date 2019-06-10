package com.demin.hera.Controller;

import com.demin.hera.Base.BaseController;
import com.demin.hera.Pojo.Admin;
import com.demin.hera.Service.AdminService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by  Domain
 * on 2019/6/10 21:14;
 */
@RestController
@RequestMapping("/admin")
public class AdminController extends BaseController<Admin, AdminService> {
}
