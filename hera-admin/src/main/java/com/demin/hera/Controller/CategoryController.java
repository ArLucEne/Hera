package com.demin.hera.Controller;

import com.demin.hera.Entity.ItemCategory;
import com.demin.hera.Entity.Response;
import com.demin.hera.Feign.ItemCategoryFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/10 13:48;
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    ItemCategoryFeign feign;

    @GetMapping("/findById")
    Response findById(@RequestParam String categoryId){
        return Response.createBySuccess(feign.findById(categoryId));
    }

    @GetMapping("/findAll")
    Response findAll(){
        return Response.createBySuccess(feign.findAll());
    }

    @GetMapping("/deleteById")
    Response deleteById(@RequestParam String categoryId){
        feign.deleteById(categoryId);
        return Response.createBySuccess();
    }

    @PostMapping(value = "/save")
    Response save(@RequestBody ItemCategory category){
        return Response.createBySuccess(feign.save(category));
    }

    @GetMapping("/existById")
    Response existById(@RequestParam String categoryId){
        return Response.createBySuccess(feign.existById(categoryId));
    }

    @PostMapping("/update")
    Response update(@RequestBody ItemCategory category){
        return Response.createBySuccess(feign.update(category));
    }

    @GetMapping("/findAllWithPage")
    Response findAllWithPage(@RequestParam int pageNum, @RequestParam int pageSize){
        return Response.createBySuccess(feign.findAllWithPage(pageNum,pageSize));
    }
}
