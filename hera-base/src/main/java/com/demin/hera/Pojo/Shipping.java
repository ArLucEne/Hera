package com.demin.hera.Pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * 物流信息
 * Created by  Domain
 * on 2019/6/4 11:20;
 */
@Getter
@Setter
@ToString
@Table(name = "db_order_shipping")
public class Shipping {
    @Id
    @GeneratedValue
    private Integer shippingId;
    private Integer orderId;
    private String receiverName;
    private String receiverPhone;
    private String receiverProvince;
    private String receiverCity;
    private String receiverAddress;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
