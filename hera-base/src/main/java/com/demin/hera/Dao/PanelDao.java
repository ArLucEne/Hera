package com.demin.hera.Dao;

import com.demin.hera.Base.BaseDao;
import com.demin.hera.Pojo.Panel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/11 15:24;
 */
@Repository
public interface PanelDao extends BaseDao<Panel,String> {
    List<Panel> findAllByRemark(String remark);

    List<Panel> findAllByItemCatId(String categoryId);


}
