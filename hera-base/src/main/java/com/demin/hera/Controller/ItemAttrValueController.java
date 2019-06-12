package com.demin.hera.Controller;

import com.demin.hera.Base.BaseController;
import com.demin.hera.Pojo.ItemAttributeValue;
import com.demin.hera.Service.ItemAttrValueService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by  Domain
 * on 2019/6/11 15:39;
 */
@RestController
@RequestMapping("/itemAttrValue")
public class ItemAttrValueController extends BaseController<ItemAttributeValue, ItemAttrValueService> {
}
