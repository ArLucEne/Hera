package com.demin.hera.Pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by  Domain
 * on 2019/6/4 11:03;
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "db_order")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;
    private Integer customerId;     //订单所属用户id
    private int status;         //订单状态 0-正在处理 1-成功 2-订单取消
    @Column(name = "order_pay_type")
    private int payType;        //支付方式
    private BigDecimal orderPay;    //订单金额
    private Integer addressId;      //订单地址id
    @Column(name = "order_postage")
    private BigDecimal postage;     //邮费
    private String shippingName;        //物流名称
    private String shippingCode;        //物流单号
    private String buyerMessage;        //买家信息
    private LocalDateTime createTime;       //订单创建时间
    private LocalDateTime updateTime;       //订单更新时间
    private LocalDateTime payTime;          //订单支付时间
    private LocalDateTime completeTime;     //订单完成时间

    public static Order getTestEntity(){
        Order test = new Order();
        test.setAddressId(2);
        test.setBuyerMessage("message");
        test.setOrderPay(new BigDecimal(43.3));
        test.setPayType(1);
        test.setShippingCode("test");
        test.setPostage(new BigDecimal(23.2));
        test.setCustomerId(3);
        test.setCreateTime(LocalDateTime.now());
        return test;
    }
}
