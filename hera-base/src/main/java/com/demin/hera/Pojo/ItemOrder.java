package com.demin.hera.Pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by  Domain
 * on 2019/6/4 11:17;
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "db_item_order")
public class ItemOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String itemOrderId;
    private String itemId;
    private String orderId;
    private int itemNum;
    private BigDecimal itemPrice;
    private String itemName;
    private String itemPoint;
    private BigDecimal totalPrice;

    public ItemOrder(){
        this.itemOrderId = UUID.randomUUID().toString().replace("-","");
    }

    public static ItemOrder getTestEntity(){
        ItemOrder test = new ItemOrder();
        test.setItemId("test");
        test.setItemName("testItem");
        test.setItemNum(3);
        test.setOrderId("test");
        test.setItemPrice(new BigDecimal(34.3));
        test.setItemPoint("good item");
        test.setTotalPrice(new BigDecimal(43.24));
        return test;
    }
}
