package com.demin.hera.Pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by  Domain
 * on 2019/6/4 10:55;
 */
@Getter
@Setter
@ToString
@Table(name = "db_item_cart")
public class ItemCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cartId;
    private Integer customerId;
    private Integer itemId;     //商品id
    private int itemNum;        //商品数量
    private BigDecimal itemPrice;       //商品价格
    private LocalDateTime createTime;
    private LocalDateTime modifyTime;
}
