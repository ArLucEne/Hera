package com.demin.hera.Pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by  Domain
 * on 2019/6/4 11:11;
 */
@Getter
@Setter
@ToString
@Table(name = "db_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer addressId;

    private String customerId;
    private String customerName;
    private int isDefault;
    @Column(name = "address_province")
    private String province;
    @Column(name = "address_city")
    private String city;
    private String addressDetail;
    private String phoneNum;
}
