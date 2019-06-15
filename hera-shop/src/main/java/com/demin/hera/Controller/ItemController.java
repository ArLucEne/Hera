package com.demin.hera.Controller;

import com.demin.hera.Entity.Item;
import com.demin.hera.Service.ItemService;
import com.demin.hera.Util.Check;
import com.demin.hera.Util.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/11 20:17;
 */

@RestController
@RequestMapping("/item")
@Api(value = "itemController")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @ApiOperation(value = "get item by id", response = Item.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "id",
                    value = "商品id", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "blob",
                    value = "0代表不包含大字段信息,1表示包含大字段信息", required = true) })

    @GetMapping(path = "/{id}/{blob}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response item(@PathVariable("id") String id, @PathVariable("blob") int blob) {
        try {
            Item data = itemService.getById(id);
            return Response.createBySuccess(data);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return Response.createByError();
    }

    @ApiOperation(value = "根据商品的ids查询商品信息返回", notes = "这个用于服务之间调用",
            response = Item.class)
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "query", dataType = "String",
            name = "blob", value = "是否包含大字段信息", required = true) })
    @ApiImplicitParam(paramType = "post body", dataType = "List<String>", name = "ids",
            value = "商品的ids", required = true)
    @PostMapping(path = "/{blob}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Item> items(@PathVariable("blob") int blob,
                               @NonNull @RequestBody List<String> ids) {
        return itemService.getIdIn(ids);

    }

    @ApiOperation(value = "get list of items by cId", response = Item.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "cId",
                    value = "商品分类的id", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "blob",
                    value = "0代表不包含大字段信息,1表示包含大字段信息", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "limit",
                    value = "限制查询的条数") })
    @GetMapping(path = { "/c/{cId}/{blob}", "/c/{cId}/{blob}/{limit}" },
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response items(@PathVariable("cId") String cId, @PathVariable("blob") int blob,
                         @PathVariable(value = "limit", required = false) Integer limit) {
        try {
            List<Item> data = itemService.getByCateId(cId, limit);
            return Response.createBySuccess(data);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return Response.createByError();
    }



}
