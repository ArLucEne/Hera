package com.demin.hera.Feign;

import com.demin.hera.Entity.Panel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/11 20:29;
 */
@FeignClient(value = "hera-base")
public interface PanelFeign {
    @RequestMapping("/panel/findById")
    Panel findById(@RequestParam("id") String panelId);

    @RequestMapping("/panel/findAll")
    List<Panel> findAll();

    @RequestMapping("/panel/deleteById")
    void deleteById(@RequestParam("id") String panelId);

    @RequestMapping(value = "/panel/save",method = RequestMethod.POST)
    Panel save(@RequestBody Panel panel);

    @RequestMapping("/panel/existById")
    boolean existById(@RequestParam("id") String panelId);

    @RequestMapping("/panel/update")
    Panel update(@RequestBody Panel panel);

    @RequestMapping("/panel/findAllWithPage")
    Object findAllWithPage(@RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize);

    @RequestMapping("/panel/findAllByRemark")
    List<Panel> findAllByRemark(@RequestParam("remark") String remark);

    @RequestMapping("/panel/findAllByItemCatId")
    List<Panel> findAllByItemCatId(@RequestParam("categoryId") String categoryId);
}
