package com.demin.hera.Pojo;

import com.demin.hera.Utils.MD5Util;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.UUID;

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
    private Long memberId;

    private String address;

    private BigDecimal balance;

    private LocalDateTime createDate;

    private String description;

    private String email;

    private String password;

    private String phone;

    private Integer point;

    private Boolean sex;

    private Integer state;

    private LocalDateTime modifyDate;
    private String remark;
    private String username;
}
