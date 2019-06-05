package com.demin.hera.Pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 物流信息
 * Created by  Domain
 * on 2019/6/4 11:20;
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "db_order_shipping")
public class Shipping implements Serializable {
    private static final long serialVersionUID = 1L;
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

    public static Shipping getTestEntity(){
        Shipping test = new Shipping();
        test.setReceiverAddress("test");
        test.setReceiverName("xiaodd");
        test.setReceiverPhone("3333333");
        test.setReceiverCity("eagjoa");
        test.setReceiverProvince("shandong");
        test.setCreateTime(LocalDateTime.now());
        return  test;
    }
}
