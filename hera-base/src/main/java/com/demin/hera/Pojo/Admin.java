package com.demin.hera.Pojo;

import com.demin.hera.Utils.MD5Util;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Created by  Domain
 * on 2019/6/4 11:23;
 */
@Setter
@Getter
@ToString
@Table(name = "db_admin")
public class Admin {
    @Id
    @GeneratedValue
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
}
