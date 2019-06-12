package com.demin.hera.Service;

import com.demin.hera.Base.BaseService;
import com.demin.hera.Pojo.Panel;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/11 15:29;
 */
public interface PanelService extends BaseService<Panel> {
    List<Panel> findAllByRemark(String remark);

    List<Panel> findAllByItemCategoryId(String categoryId);
}
