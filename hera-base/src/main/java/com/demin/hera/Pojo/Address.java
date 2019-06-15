package com.demin.hera.Pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

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

    private String addressId;

    private Integer isDefault;

    private String streetName;

    private String tel;

    private String userId;

    private String userName;

}
