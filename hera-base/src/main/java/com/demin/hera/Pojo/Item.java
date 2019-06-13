package com.demin.hera.Pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by  Domain
 * on 2019/6/4 10:11;
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "db_item")

public class Item implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String itemId;

    private String name;

    private Long cId;

    private String itemCatName;

    private String sellPoint;

    private BigDecimal price;

    private Integer limitNum;

    private String image;

    private String remark;

    private String description;

    private Integer sortOrder;

    private Integer sale;
}
