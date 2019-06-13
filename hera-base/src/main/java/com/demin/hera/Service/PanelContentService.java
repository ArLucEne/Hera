package com.demin.hera.Service;

import com.demin.hera.Base.BaseService;
import com.demin.hera.Pojo.PanelContent;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/11 15:28;
 */
public interface PanelContentService extends BaseService<PanelContent> {
    List<PanelContent> findAllByProductId(String itemId);

    List<PanelContent> findAllByPanelId(Integer panelId);
}
