package com.demin.hera.Pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ItemOrderId;
    private Integer itemId;
    private Integer orderId;
    private int itemNum;
    private BigDecimal itemPrice;
    private String itemName;
    private String itemPoint;
    private BigDecimal totalPrice;

    public static ItemOrder getTestEntity(){
        ItemOrder test = new ItemOrder();
        test.setItemId(1);
        test.setItemName("testItem");
        test.setItemNum(3);
        test.setOrderId(2);
        test.setItemPrice(new BigDecimal(34.3));
        test.setItemPoint("good item");
        test.setTotalPrice(new BigDecimal(43.24));
        return test;
    }
}
