package com.demin.hera.Controller;

import com.demin.hera.Base.BaseController;
import com.demin.hera.Pojo.Panel;
import com.demin.hera.Pojo.PanelContent;
import com.demin.hera.Service.PanelContentService;
import com.demin.hera.Service.PanelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/11 15:36;
 */
@RestController
@RequestMapping("/panel")
public class PanelController extends BaseController<Panel, PanelService> {

    @GetMapping("/findAllByRemark")
    List<Panel> findAllByRemark(String remark){
        return super.baseService.findAllByRemark(remark);
    }

    @GetMapping("/findAllByItemCatId")
    List<Panel> findAllByItemCatId(Long categoryId){
        return super.baseService.findAllByItemCatId(categoryId);
    }
}
