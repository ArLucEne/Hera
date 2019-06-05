package com.demin.hera.Pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by  Domain
 * on 2019/6/4 11:11;
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "db_address")
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer addressId;

    private Integer customerId;
    private String customerName;
    private int isDefault;
    @Column(name = "address_province")
    private String province;
    @Column(name = "address_city")
    private String city;
    private String addressDetail;
    private String phoneNum;

    public static Address getTestEntity(){
        Address test = new Address();
        test.setAddressId(100);
        test.setCustomerId(100);
        test.setCustomerName("test");
        test.setIsDefault(1);
        test.setCity("weihai");
        test.setProvince("shandong");
        test.setPhoneNum("88888888");
        test.setAddressDetail("wenhuaxilu");
        return test;
    }
}
