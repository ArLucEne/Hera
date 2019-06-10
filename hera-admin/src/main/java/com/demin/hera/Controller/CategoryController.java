package com.demin.hera.Controller;

import com.demin.hera.Entity.Response;
import com.demin.hera.Feign.CategoryFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by  Domain
 * on 2019/6/10 13:48;
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    public static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    CategoryFeign categoryFeign;

    @RequestMapping("/findAll")
    public Response findAll(){
        LOGGER.info("CATEGORY FEIGN TO HERA-BASE USE FINDALL");
        return Response.createBySuccess(categoryFeign.findAll());
    }
}
