package com.demin.hera.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Created by  Domain
 * on 2019/6/4 10:59;
 */
@Getter
@Setter
@ToString

public class ItemCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long itemCatId;

    private LocalDateTime createDate;

    private String icon;


    private Boolean isParent;


    private String name;

    private Long parentId;

    private String remark;

    private Integer sortOrder;

    private Integer state;

    private LocalDateTime modifyDate;


    private List<ItemCategory> childCates;

    private List<Item> items;


}
