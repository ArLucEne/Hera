package com.demin.hera.Contorller;

import com.demin.hera.Entity.EsItem;
import com.demin.hera.Service.essearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by  Domain
 * on 2019/6/9 9:42;
 */
@RestController
public class testController {
    @Autowired
    essearch service;

    @RequestMapping("/searchTest")
    public Object test(@RequestParam String key){
        return   service.queryByKey(key);
    }
}
