package com.demin.hera.Pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 订单
 * Created by  Domain
 * on 2019/6/4 11:03;
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "db_order")
public class  Order implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String orderId;

    /**
     * 实付金额
     */
    private BigDecimal payment;

    /**
     * 支付方式
     */
    private Integer paymentType;

    /**
     * 邮费
     */
    private BigDecimal postFee;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private Date paymentTime;

    private Date endTime;

    private Date closeTime;

    /**
     * 物流名称
     */
    private String shippingName;

    /**
     * 物流单号
     */
    private String shippingCode;

    /**
     * 买家id
     */
    private String buyerId;

    /**
     * 买家留言
     */
    private String buyerMessage;

    private String buyerNick;

    private String sellerId;

    private String sellerNick;

    private Integer buyerComment;

    private String address;

    @Transient
    private List<ItemOrder> itemOrderList;




}
