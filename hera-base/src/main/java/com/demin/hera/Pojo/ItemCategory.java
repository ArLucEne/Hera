package com.demin.hera.Pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

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

    private String itemCatId;

    private LocalDateTime createDate;

    private String icon;


    private Boolean isParent;


    private String name;

    private String parentId;

    private String remark;

    private Integer sortOrder;

    private Integer state;

    private LocalDateTime modifyDate;

}
