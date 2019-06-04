package com.demin.hera.Pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by  Domain
 * on 2019/6/4 10:59;
 */
@Getter
@Setter
@ToString
@Table(name = "db_item_category")
public class ItemCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer categoryId;
    @Column(name = "category_name")
    private String name;
    @Column(name = "category_image_addr")
    private String imageAddr;
    private int isParent;
    private Integer parentId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
