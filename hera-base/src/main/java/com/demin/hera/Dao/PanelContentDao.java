package com.demin.hera.Dao;

import com.demin.hera.Base.BaseDao;
import com.demin.hera.Pojo.PanelContent;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/11 15:25;
 */
@Repository
public interface PanelContentDao extends BaseDao<PanelContent,String> {
    List<PanelContent> findAllByProductId(String itemId);

    List<PanelContent> findAllByPanelId(Integer panelId);
}
