package com.demin.hera.Controller;

import com.demin.hera.Entity.ItemCategory;
import com.demin.hera.Service.ItemCategoryService;
import com.demin.hera.Util.Check;
import com.demin.hera.Util.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/12 10:52;
 */
@RestController
@RequestMapping("/itemCat")
@Api(value = "商品分类")

public class CategoryController {

    @Autowired
    private final ItemCategoryService itemCatService;

    @Autowired
    public CategoryController(ItemCategoryService itemCatService) {
        this.itemCatService = itemCatService;
    }

    @ApiOperation(value = "得到首页左侧展示的根商品分类和相关的商品信息", response = ItemCategory.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "Integer",
                    name = "catLimit", value = "商品分类的数量,推荐是20"),
            @ApiImplicitParam(paramType = "query", dataType = "Integer",
                    name = "itemLimit", value = "商品的数量,推荐是12") })

    @GetMapping(path = "/ro/{catLimit}/{itemLimit}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response rootCatWithItems(@PathVariable Integer catLimit,
                                    @PathVariable Integer itemLimit) {

        try {
            List<List<ItemCategory>> data = itemCatService.getRootCat(catLimit, itemLimit);
            return Response.createBySuccess(data);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return Response.createByError();
    }

    @ApiOperation(value = "得到导航栏的展示信息", response = ItemCategory.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "Integer",
                    name = "catLimit", value = "商品分类的数量,推荐是10"),
            @ApiImplicitParam(paramType = "query", dataType = "Integer",
                    name = "itemLimit", value = "商品的数量,推荐是5") })
    @GetMapping(path = "/nav/{catLimit}/{itemLimit}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response navCatWithItems(@PathVariable Integer catLimit,
                                   @PathVariable Integer itemLimit) {
        return Response
                .createBySuccess(itemCatService.getItemCatWithItemsByRemark("nav", catLimit, itemLimit));
    }

}