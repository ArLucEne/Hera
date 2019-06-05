package com.demin.hera.Pojo;

import com.demin.hera.Utils.MD5Util;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by  Domain
 * on 2019/6/4 11:23;
 */
@Setter
@Getter
@ToString
@Entity
@Table(name = "db_admin")
public class Admin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer adminId;
    @Column(name = "admin_name")
    private String name;
    @Column(name = "admin_email")
    private String email;
    @Column(name = "admin_password")
    private String password;
    @Column(name = "admin_role")
    private int role;
    @Column(name = "admin_last_login_time")
    private LocalDateTime lastLoginTime;

    public void encodePwd(){
        this.password = MD5Util.encodeMD5(password);
    }

    public static Admin getTestEntity(){
        Admin test = new Admin();
        test.setAdminId(100);
        test.setName("testAdmin");
        test.setEmail("awegjoaw@qq.com");
        test.setPassword("test");
        test.setRole(1);
        test.setLastLoginTime(LocalDateTime.now());

        test.encodePwd();

        return test;
    }
}
