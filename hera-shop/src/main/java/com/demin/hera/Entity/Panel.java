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

    private Integer limitNum;

    private String name;

    private String remark;

    private Integer sortOrder;

    private Integer status;

    private Integer type;

    private String itemCatId;

    private List<Item> itemDtoList;


}
