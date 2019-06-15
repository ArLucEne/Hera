package com.demin.hera.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by  Domain
 * on 2019/6/12 11:05;
 */
@Getter
@Setter
@ToString
public class ItemOrder implements Serializable {
    private static final long serialVersionUID = -2669286586484973878L;

    private String id;

    private String itemId;

    private String orderId;

    /**
     * 商品购买的数量
     */
    private Integer itemNum;

    /**
     * 商品单价
     */
    private BigDecimal itemPrice;

    /**
     * 商品总金额
     */
    private BigDecimal itemTotalPrice;

    private String itemName;

    private String itemImage;

    private String itemSellPoint;

}
