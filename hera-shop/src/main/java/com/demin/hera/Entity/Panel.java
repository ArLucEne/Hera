package com.demin.hera.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * 版块
 * Created by  Domain
 * on 2019/6/11 15:10;
 */
@ToString
@Getter
@Setter

public class Panel implements Serializable {
    private static final long serialVersionUID = 1L;

    private String panelId;

    private LocalDateTime createDate;
    private Integer limitNum;

    private String name;

    private String remark;      //版块标签
    private Integer sortOrder;
    private Integer status;
    private Integer type;

    private LocalDateTime modifyDate;

    private String itemCategoryId;

    public List<Item> ItemList;

    public Panel(){
        this.panelId = UUID.randomUUID().toString().replace("-","");
    }
}
