package com.demin.hera.Pojo;

import com.demin.hera.Utils.MD5Util;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;

/**
 * Created by  Domain
 * on 2019/6/4 9:42;
 */
@Setter
@Getter
@ToString
@Entity
@Table(name = "db_customer")
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerId;
    @Column(name = "customer_name")
    private String name;
    @Column(name = "customer_email")
    private String email;
    @Column(name = "customer_phone")
    private String phone;
    @Column(name = "customer_sex")
    private int sex;            //0:boy 1：girl
    @Column(name = "customer_password")
    private String password;
    private LocalDateTime createTime;
    private LocalDateTime lastLoginTime; //上一次登陆时间
    private int state;      //后续使用

    public void encodePwd(){
        this.password = MD5Util.encodeMD5(password);
    }

    public static Customer getTestEntity(){
        Customer test = new Customer();
        test.setCustomerId(100);
        test.setEmail("test@qq.com ");
        test.setName("testCustomer");
        test.setPassword("test");
        test.setPhone("922935205");
        test.setSex(1);
        test.setState(1);
        test.setCreateTime(LocalDateTime.now());
        test.setLastLoginTime(LocalDateTime.now());

        test.encodePwd();

        return test;
    }
}
