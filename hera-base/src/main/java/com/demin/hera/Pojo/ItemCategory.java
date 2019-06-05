package com.demin.hera.Pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by  Domain
 * on 2019/6/4 10:59;
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "db_item_category")
public class ItemCategory implements Serializable {
    private static final long serialVersionUID = 1L;
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

    public static ItemCategory getTestEntity(){
        ItemCategory test = new ItemCategory();
        test.setName("testCategory");
        test.setIsParent(1);
        test.setImageAddr("testURl");
        test.setCreateTime(LocalDateTime.now());
        test.setUpdateTime(LocalDateTime.now());
        return test;
    }
}
