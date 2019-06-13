package com.demin.hera.Pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * order item关系
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
