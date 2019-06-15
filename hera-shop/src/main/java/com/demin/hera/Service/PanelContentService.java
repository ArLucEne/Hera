package com.demin.hera.Service;

import com.demin.hera.Entity.PanelContent;
import com.demin.hera.Feign.PanelContentFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by  Domain
 * on 2019/6/12 8:31;
 */
@Service
public class PanelContentService {
    @Autowired
    PanelContentFeign feign;

    public List<String> getItemIdByPanelId(String panelId,Integer limit){
        List<PanelContent> panelContentList = feign.findAllByPanelId(panelId);
        List<String> itemIds = new LinkedList<>();
        if (limit>panelContentList.size()){
            for(PanelContent content:panelContentList){
                itemIds.add(content.getProductId());
            }
        }else {
            for(int i = 0;i<limit;i++){
                itemIds.add(panelContentList.get(i).getProductId());
            }
        }
        return itemIds;
    }

}
