package com.demin.hera.Feign;

import com.demin.hera.Entity.ItemCategory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/12 10:07;
 */
@FeignClient(value = "hera-base")
public interface ItemCategoryFeign {
    @RequestMapping("/category/findAllByParentId")
    List<ItemCategory> findAllByParentId(@RequestParam("parentId") Long parentId);

    @RequestMapping("/category/findAllByRemark")
    List<ItemCategory> findAllByRemark(@RequestParam("remark") String remark);
}
