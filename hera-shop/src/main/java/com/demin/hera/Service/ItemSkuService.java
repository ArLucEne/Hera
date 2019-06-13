package com.demin.hera.Service;

import com.demin.hera.Entity.ItemAttribute;
import com.demin.hera.Entity.ItemSku;
import com.demin.hera.Feign.ItemSkuFeign;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by  Domain
 * on 2019/6/12 9:42;
 */
@Service
public class ItemSkuService {
    @Autowired
    ItemSkuFeign feign;

    public List<ItemAttribute> getItemInfo(String itemId){
        List<ItemSku> itemSkuList = feign.findAllByItemId(itemId);
        List<ItemAttribute> attributes = new LinkedList<>();
        for(ItemSku sku:itemSkuList){
            ItemAttribute itemAttribute = new ItemAttribute();
            String attributeStr = sku.getAttributes();
            List<String> attributesList = Lists.newArrayList(attributeStr.split(";"));
            List<Map<Long, Long>> list = attributesList.stream().map(attribute -> {
                Map<Long, Long> map = new HashMap<>();
                String[] properties = attribute.split(":");
                map.put(Long.valueOf(properties[0]), Long.valueOf(properties[1]));
                return map;
            }).collect(Collectors.toList());
            itemAttribute.setAttributes(list);
            itemAttribute.setPrice(sku.getPrice());
            attributes.add(itemAttribute);
        }
        return attributes;
    }
}
