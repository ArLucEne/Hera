package com.demin.hera.Service;

import com.demin.hera.BaseTest;
import com.demin.hera.Pojo.Item;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by  Domain
 * on 2019/6/5 9:02;
 */
public class ItemServiceTest extends BaseTest {

    @Autowired
    ItemService itemService;
    @Test
    public void save() {
        Item test = Item.getTestEntity();
        Item item = itemService.save(test);
        System.out.println(item.toString());
        test = itemService.findById(7);
        System.out.println(test.toString());
    }
}