package com.demin.hera.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by  Domain
 * on 2019/6/12 20:41;
 */
@Setter
@Getter
@ToString
public class Customer implements Serializable {
    private static final long serialVersionUID = 8391494979684624720L;

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
