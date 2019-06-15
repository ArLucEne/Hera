package com.demin.hera.ServiceImpl;

import com.demin.hera.Base.BaseServiceImpl;
import com.demin.hera.Dao.PanelContentDao;
import com.demin.hera.Pojo.PanelContent;
import com.demin.hera.Service.PanelContentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/11 15:32;
 */
@Service
public class PanelContentServiceImpl extends BaseServiceImpl<PanelContent, PanelContentDao> implements PanelContentService {

    @Override
    public List<PanelContent> findAllByProductId(String itemId) {
        return super.baseDao.findAllByProductId(itemId);
    }

    @Override
    public List<PanelContent> findAllByPanelId(String panelId) {
        return super.baseDao.findAllByPanelId(panelId);
    }
}
