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
 * on 2019/6/11 15:14;
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "db_item_sku")
public class ItemSku implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id

    private String itemSkuId;

    private String itemId;

    /**
     * 参数名:参数值这种形式
     */
    private String attributes;

    private BigDecimal price;

    private BigDecimal cost;

    /**
     * 库存
     */
    private Integer stock;
}
