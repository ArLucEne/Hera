package com.demin.hera.Controller;

import com.demin.hera.Entity.ItemCart;
import com.demin.hera.Service.ItemCartService;
import com.demin.hera.Util.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Created by  Domain
 * on 2019/6/11 19:02;
 */


@RestController
@RequestMapping(path = "/cart")
@Api(value = "购物车")
public class ItemCartController {

    public static final Logger LOGGER = LoggerFactory.getLogger(ItemCartController.class);

    private final ItemCartService itemCartService;

    @Autowired
    public ItemCartController(ItemCartService itemCartService) {
        this.itemCartService = itemCartService;
    }

    @ApiOperation(value = "添加购物车记录", response = Boolean.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "insert", dataType = "ItemCart", name = "itemCart", value = "购物车记录信息") })
    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response add(@RequestBody ItemCart itemCart) {

        LOGGER.info("Request to /cart -POST"+itemCart.toString());
        if (itemCartService.add(itemCart)) {
            LOGGER.info("add cart success");
            return Response.createBySuccess(null);
        }
        else {
            return Response.createByErrorMessage("添加商品到购物车失败,请重试");
        }
    }

    @ApiOperation(value = "列出指定用户的购物车记录", response = ItemCart.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "nickName", value = "用户的昵称") })
    @GetMapping(path = "/list/{nickName}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response list(@PathVariable String nickName) {
        return Response.createBySuccess(itemCartService.list(nickName));
    }

    @ApiOperation(value = "更新指定用户的某个商品的数量")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "nickName", value = "用户的昵称"),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "itemId", value = "商品的id"),
            @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "quantity", value = "商品更新后的数量"), })
    @PatchMapping(path = "/{nickName}/{itemId}/{quantity}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response patch(@PathVariable String nickName, @PathVariable String itemId,
                         @PathVariable Integer quantity) {
        if (itemCartService.updateNum(nickName, itemId, quantity)) {
            return Response.createBySuccess();
        }
        else {
            return Response.createByErrorMessage("更新商品数量失败");
        }
    }

    @ApiOperation(value = "清空某个用户的购物车")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "nickName", value = "用户的昵称") })
    @DeleteMapping(path = "/{nickName}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response clear(@PathVariable String nickName) {
        if (itemCartService.clear(nickName)) {
            return Response.createBySuccess();
        }
        else {
            return Response.createByErrorMessage("清空购物车失败");
        }
    }

    @ApiOperation(value = "删除购物车中单个商品")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "nickName", value = "用户的昵称"),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "itemId", value = "商品的id") })
    @DeleteMapping(path = "/{nickName}/{itemId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@PathVariable String nickName, @PathVariable String itemId) {
        if (itemCartService.delete(nickName, itemId)) {
            return Response.createBySuccess();
        }
        else {
            return Response.createByErrorMessage("删除失败");
        }
    }

    @ApiOperation(value = "更新购物车中多种商品状态信息为订单状态")
    @ApiImplicitParam(paramType = "update", dataType = "List<Long>", name = "itemCartIds", value = "购物车条目的ids")
    @PatchMapping(path = "")
    public Response submitOrder(@RequestBody List<String> itemCartIds) {
        if (itemCartService.submitOrder(itemCartIds)) {
            return Response.createBySuccess();
        }
        else {
            return Response.createByError();
        }
    }

}

























/*
@RestController
@RequestMapping("/cart")
public class ItemCartController {
    @Autowired
    ItemCartService service;

    @PostMapping("/add")
    public Response add(@RequestBody ItemCart itemCart){
        if(service.add(itemCart))
            return Response.createBySuccess();
        else
            return Response.createByErrorResponse("添加商品到购物车失败");
    }
    @GetMapping("/list")
    public Response list(@RequestParam String customerName){
        return Response.createBySuccess(service.list(customerName));
    }

    @GetMapping("/updateNum")
    public Response updateNum(@RequestParam String customerName,String itemId,int num){
        if (service.updateNum(customerName, itemId, num))
            return Response.createBySuccess();
        else
            return Response.createByErrorResponse("更新商品数量失败");
    }
    @GetMapping("/clear")
    public Response clear(@RequestParam String customerName){
        if (service.clear(customerName))
            return Response.createBySuccess();
        else
            return Response.createByErrorResponse("清空购物车失败");
    }

    @GetMapping("/delete")
    public Response delete(@RequestParam String customerName,String itemId){
        if (service.delete(customerName, itemId))
            return Response.createBySuccess();
        else
            return Response.createByErrorResponse("删除失败");
    }

    @PostMapping("/submit")
    public Response submitOrder(@RequestBody List<String> itemCartIds){
        if (service.submitOrder(itemCartIds))
            return Response.createBySuccess();
        else
            return Response.createByErrorResponse("提交订单失败");
    }

}
*/