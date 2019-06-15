package com.demin.hera.Service;

import com.demin.hera.Entity.Item;
import com.demin.hera.Entity.Panel;
import com.demin.hera.Feign.PanelFeign;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/12 8:19;
 */
@Service
public class PanelService {
    @Autowired
    PanelFeign panelfeign;

    @Autowired
    PanelContentService panelContentService;

    @Autowired
    ItemService itemService;

    /**
     * 得到每个标签的panel，并根据PanelContent中的ItemId填充itemList
     * @param remark
     * @param panelLimit
     * @param itemLimit
     * @return
     */
    public List<Panel> getPanelByRemark(String remark,Integer panelLimit,Integer itemLimit){
        List<Panel> panelList = panelfeign.findAllByRemark(remark);
        List<Panel> panelResults = new LinkedList<>();
        for(int i = 0;i<panelLimit;i++)
            panelResults.add(panelList.get(i));
        for(Panel panel:panelResults)
            addItemListToPanel(panel,itemLimit);
        return panelResults;
    }

    public List<Panel> getPanelByCateId(String cateId,Integer itemlimit){
        List<Panel> panels = panelfeign.findAllByItemCatId(cateId);
        for(Panel panel:panels)
            addItemListToPanel(panel,itemlimit);
        return panels;
    }

    public List<Panel> getPanelByCateIds(List<String> cateIds,Integer itemLimit){
        List<Panel> panelList = new LinkedList<>();
        for(String cateId:cateIds)
            panelList.addAll(getPanelByCateId(cateId,itemLimit));
        return panelList;
    }

    public Panel getPanelById(String panelId){
        Panel panel = panelfeign.findById(panelId);
        return addItemListToPanel(panel,10);
    }

    public List<Panel> getPanelsByCateIds(List<String> cateIds){
        return getPanelByCateIds(cateIds,10);
    }

    private Panel addItemListToPanel(Panel panel,Integer limit){
        try {
            List<String> itemIds = panelContentService.getItemIdByPanelId(panel.getPanelId(),limit);
            List<Item> items = itemService.getIdIn(itemIds);
            panel.setItemDtoList(items);
            return panel;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
