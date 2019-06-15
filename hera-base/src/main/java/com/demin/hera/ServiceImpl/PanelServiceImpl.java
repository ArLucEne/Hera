package com.demin.hera.ServiceImpl;

import com.demin.hera.Base.BaseServiceImpl;
import com.demin.hera.Dao.PanelDao;
import com.demin.hera.Pojo.Panel;
import com.demin.hera.Service.PanelService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/11 15:31;
 */
@Service
public class PanelServiceImpl extends BaseServiceImpl<Panel, PanelDao> implements PanelService {
    @Override
    public List<Panel> findAllByRemark(String remark) {
        return super.baseDao.findAllByRemark(remark);
    }

    @Override
    public List<Panel> findAllByItemCatId(String categoryId) {
        return super.baseDao.findAllByItemCatId(categoryId);
    }


}
