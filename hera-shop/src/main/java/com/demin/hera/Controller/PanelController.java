package com.demin.hera.Controller;

import com.demin.hera.Entity.Panel;
import com.demin.hera.Service.PanelService;
import com.demin.hera.Util.Check;
import com.demin.hera.Util.Response;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/12 9:06;
 */
@RestController
@RequestMapping("/panel")
public class PanelController {
    @Autowired
    PanelService panelService;

    @GetMapping("/getPanelByRemark")
    public Response getPanelByRemark(@RequestParam String remark,Integer panelLimit,Integer itemLimit){
        List<Panel> panelList = panelService.getPanelByRemark(remark, panelLimit, itemLimit);
        if (Check.isNotNull(panelLimit))
            return Response.createBySuccess(panelList);
        else
            return Response.createByError();
    }
    @GetMapping("/getPanelByCateId")
    public Response getPanelByCateId(@RequestParam String cateId,Integer itemLimit){
        List<Panel> panelList = panelService.getPanelByCateId(cateId,itemLimit);
        if(Check.isNotNull(panelList))
            return Response.createBySuccess(panelList);
        else
            return Response.createByError();
    }

    @GetMapping(path = "/cat/{cateId1}/{cateId2}/{itemLimit}")
    public Response panelWithCatsAndItems(@PathVariable Integer itemLimit,
                                         @PathVariable String cateId1, @PathVariable String cateId2) {
        List<String> cateIds = Lists.newArrayList(cateId1, cateId2);
        List<Panel> panelList = panelService.getPanelByCateIds(cateIds,itemLimit);
        if (Check.isNotNull(panelList))
            return Response.createBySuccess(panelList);
        else
            return Response.createByError();
    }

    @GetMapping("/getPanelById")
    public Response getPanelById(@RequestParam String panelId){
        Panel panel = panelService.getPanelById(panelId);
        if (Check.isNotNull(panel))
            return Response.createBySuccess(panel);
        else
            return Response.createByError();
    }
}
