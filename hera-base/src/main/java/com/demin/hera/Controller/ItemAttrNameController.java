package com.demin.hera.Controller;

import com.demin.hera.Base.BaseController;
import com.demin.hera.Pojo.ItemAttributeName;
import com.demin.hera.Service.ItemAttrNameService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by  Domain
 * on 2019/6/11 15:38;
 */
@RestController
@RequestMapping("/itemAttrName")
public class ItemAttrNameController extends BaseController<ItemAttributeName, ItemAttrNameService> {
}
