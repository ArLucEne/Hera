package com.demin.hera.Controller;

import com.demin.hera.Base.BaseController;
import com.demin.hera.Pojo.PanelContent;
import com.demin.hera.Service.PanelContentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/11 15:37;
 */
@RestController
@RequestMapping("/panelContent")
public class PanelContentController extends BaseController<PanelContent, PanelContentService> {
    @GetMapping("/findAllByProductId")
    List<PanelContent> findAllByProductId(String itemId){
        return super.baseService.findAllByProductId(itemId);
    }

    @GetMapping("/findAllByPanelId")
    List<PanelContent> findAllByPanelId(String panelId){
        return super.baseService.findAllByPanelId(panelId);
    }
}
