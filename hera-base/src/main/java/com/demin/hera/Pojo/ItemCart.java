package com.demin.hera.Pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

/**
 * Created by  Domain
 * on 2019/6/4 10:55;
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "db_item_cart")
public class ItemCart implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id

    private String itemCartId;

    private String memberId;

    private Date createDate;

    private Date modifyDate;

    private String remark;

    private Integer itemCartStatus;

    /**
     * 数量
     */
    private Integer quantity;

    private String itemId;

    private BigDecimal price;

    private String itemCatId;

    private String memberNickname;

    private String itemImage;

    private String itemSellPoint;

    private String itemName;

}
