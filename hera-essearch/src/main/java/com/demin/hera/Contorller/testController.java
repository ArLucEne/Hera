package com.demin.hera.Contorller;

import com.demin.hera.Entity.EsItem;
import com.demin.hera.Service.Essearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/9 9:42;
 */
@RestController
@CrossOrigin
public class testController {
    @Autowired
    Essearch service;

    @GetMapping("/search")
    public Object test(@RequestParam String key){
        return   service.queryByKey(key);

    }

    @PostMapping("/recommend")
    public Object recommend(@RequestBody List<String> itemIds){
        return service.recommend(itemIds);
    }

    @GetMapping("/sync")
    public Object sync(){
        return service.syncData();
    }
}
