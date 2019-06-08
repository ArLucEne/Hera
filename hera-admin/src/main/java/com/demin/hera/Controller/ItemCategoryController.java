package com.demin.hera.Controller;

import com.demin.hera.Pojo.ItemCategory;
import com.demin.hera.Service.ItemCategoryService;
import com.demin.hera.Utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/7 13:53;
 */
@RestController
@CrossOrigin
@RequestMapping("/category")
public class ItemCategoryController {
    @Autowired
    ItemCategoryService service;


    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Response save(@RequestBody ItemCategory ItemCategory){
        ItemCategory result = service.save(ItemCategory);
        if(result != null)
            return Response.createBySuccess(result);
        else
            return Response.createByError();
    }

    @RequestMapping("/getAll")
    public Response getAll(@RequestParam int pageNum,@RequestParam int pageSize){
        List items = service.getAllWithPage(pageNum,pageSize);
        return Response.createBySuccess(items);
    }

    @RequestMapping("/deleteById")
    public Response deleteById(@RequestParam String itemId){
        service.deleteById(itemId);
        if (service.findById(itemId) == null)
            return Response.createBySuccess();
        else
            return Response.createByError();
    }

/*    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Response update(@RequestBody ItemCategory ItemCategory){
        ItemCategory resule = service.update(ItemCategory);
        if (resule != null) {
            return Response.createBySuccess(resule);
        }else
            return Response.createByError();
    }*/

    @RequestMapping("/findById")
    public Response findById(@RequestParam String categoryId){
        ItemCategory result = service.findById(categoryId);
        if(result != null)
            return Response.createBySuccess(result);
        else
            return Response.createByError();
    }

}
