package com.demin.hera.Controller;

import com.demin.hera.Entity.Panel;
import com.demin.hera.Service.PanelService;
import com.demin.hera.Util.Check;
import com.demin.hera.Util.Response;
import com.google.common.collect.Lists;
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
 * on 2019/6/12 9:06;
 */
@RestController
@RequestMapping("/panel")
@Api(value = "panelController", description = "handle panel")
public class PanelController {

    private final PanelService panelService;

    @Autowired
    public PanelController(PanelService panelService) {
        this.panelService = panelService;
    }

    @ApiOperation(value = "得到版块信息和对应版块的商品的信息", response = Panel.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "remark", value = "版块remark,目前有index版块"),
            @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "panelLimit", value = "版块的查询限制条数"),
            @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "itemLimit", value = "商品的查询限制条数"), })

    @GetMapping(path = { "/re/{remark}", "/re/{remark}/{panelLimit}",
            "/re/{remark}/{panelLimit}/{itemLimit}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response panel(@PathVariable("remark") String remark,
                         @PathVariable(value = "panelLimit", required = false) Integer panelLimit,
                         @PathVariable(value = "itemLimit", required = false) Integer itemLimit) {
        try {
            List<Panel> data = panelService.getPanelByRemark(remark, panelLimit,
                    itemLimit);
            return Response.createBySuccess(data);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return Response.createByError();
    }

    @ApiOperation(value = "点击商品分类,查看商品分类下的版块(包含商品)", response = Panel.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "cId", value = "商品分类id"),
            @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "limit", value = "限制显示的商品数量")

    })
    @GetMapping(path = { "/cat/{cId}",
            "/cat/{cId}/{limit}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response panelWithItems(@PathVariable("cId") String itemCatId,
                                  @PathVariable(value = "limit", required = false) Integer limit) {
        try {
            List<Panel> data = panelService.getPanelByCateId(itemCatId,
                    limit);
            return Response.createBySuccess(data);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return Response.createByError();
    }

    @ApiOperation(value = "获取指定分类下面的模块信息,可以指定两个分类的id", response = Panel.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "cId1", value = "第一个分类的id"),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "cId2", value = "第二个分类的id"),
            @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "itemLimit", value = "每一个版块下商品的数量"), })


    @GetMapping(path = "/cat/{cId1}/{cId2}/{itemLimit}")
    public Response panelWithCatsAndItems(@PathVariable Integer itemLimit,
                                         @PathVariable String cId1, @PathVariable String cId2) {
        List<String> catIds = Lists.newArrayList(cId1, cId2);
        return Response
                .createBySuccess(panelService.getPanelByCateIds(catIds, itemLimit));
    }

    @ApiOperation(value = "根据版块的id查找对应的版块信息，包含对应的商品信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "panelId", value = "版块的id") })
    @GetMapping(path = "/{panelId}")
    public Response panel(@PathVariable String panelId) {
        Panel panelDto = panelService.getPanelById(panelId);
        return Response.createBySuccess(panelDto);
    }

}
