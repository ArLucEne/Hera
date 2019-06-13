package com.demin.hera.Controller;

import com.demin.hera.Base.BaseController;
import com.demin.hera.Pojo.Item;
import com.demin.hera.Service.ItemService;
import com.demin.hera.Utils.Response;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/10 8:29;
 */
@RestController
@RequestMapping("/item")
public class ItemController extends BaseController<Item,ItemService> {

    @GetMapping("/findByName")
    public Item findByName(String name){
        return super.baseService.findByName(name);
    }
    @GetMapping("/findAllByCId")
    List<Item> findAllByCId(Long cid){
        return super.baseService.findAllByCId(cid);
    }


}
