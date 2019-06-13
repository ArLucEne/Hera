package com.demin.hera.Controller;

import com.demin.hera.Entity.Customer;
import com.demin.hera.Service.CustomerService;
import com.demin.hera.Util.MD5Util;
import com.demin.hera.Util.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


/**
 * Created by  Domain
 * on 2019/6/12 20:55;
 */
@RestController
@RequestMapping("/customer")
@Api(value = "用户操作")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "/{name}")
    @ApiOperation(value = "根据用户名查询用户的基本信息")
    @ApiImplicitParam(paramType = "query", dataType = "String", name = "name",
            value = "用户的当前名称")
    Response get(@PathVariable String name) {
        return Response.createBySuccess(customerService.getByName(name));
    }

    @PatchMapping("/pay/{memberId}/{payment}")
    @ApiOperation(value = "扣除指定用户相关金额")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "Long", name = "customerId"),
            @ApiImplicitParam(paramType = "update", dataType = "BigDecimal",
                    name = "payment") })
    Response pay(@PathVariable String customerId, @PathVariable BigDecimal payment) {
        if (customerService.pay(customerId, payment)) {
            return Response.createBySuccess(customerService.getById(customerId));
        }
        else {
            return Response.createByErrorMessage("您的钱不足");
        }
    }

    @GetMapping("/customerId")
    @ApiOperation("根据用户id获取用户信息")
    Response getById(@NotNull @PathVariable String customerId) {
        return Response.createBySuccess(customerService.getById(customerId));
    }

    @GetMapping("/login/{userName}/{password}")
    Response login(@PathVariable String userName,@PathVariable String password){
        Customer customer = customerService.getByName(userName);
        if( customer.getPassword().equals(password)){
            return Response.createBySuccess(customer);
        }else
            return Response.createByError();
    }

}
