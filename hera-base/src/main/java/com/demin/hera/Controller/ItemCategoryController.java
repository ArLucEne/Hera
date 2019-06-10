package com.demin.hera.Controller;

import com.demin.hera.Base.BaseController;
import com.demin.hera.Pojo.ItemCategory;
import com.demin.hera.Service.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/10 8:32;
 */
@RestController
@RequestMapping("/category")
public class ItemCategoryController extends BaseController<ItemCategory,ItemCategoryService> {

}
