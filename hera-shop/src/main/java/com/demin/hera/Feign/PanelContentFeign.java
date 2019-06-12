package com.demin.hera.Feign;

import com.demin.hera.Entity.PanelContent;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/12 8:23;
 */
@FeignClient(value = "hera-base")
public interface PanelContentFeign {

    @RequestMapping("/panelContent/findAllByItemId")
    List<PanelContent> findAllByItemId(@RequestParam("itemId") String itemId);

    @RequestMapping("/panelContent/findAllByPanelId")
    List<PanelContent> findAllByPanelId(@RequestParam("panelId") String panelId);
}
