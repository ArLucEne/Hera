package com.demin.hera.Pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by  Domain
 * on 2019/6/4 11:17;
 */
@Getter
@Setter
@ToString
@Table(name = "db_item_order")
public class ItemOrder {
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
}
