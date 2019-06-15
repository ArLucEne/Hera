package com.demin.hera.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by  Domain
 * on 2019/6/10 13:45;
 */
@Setter
@Getter
@ToString
public class ItemCategory implements Serializable {
    private static final long serialVersionUID = 1L;

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
