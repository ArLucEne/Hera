package com.demin.hera.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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

public class ItemCategory implements Serializable {
    private static final long serialVersionUID = 1L;

    private String categoryId;
    private String name;
    private String imageAddr;
    private int isParent;
    private String parentId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public ItemCategory(){
        this.categoryId = UUID.randomUUID().toString().replace("-","");
    }

}
