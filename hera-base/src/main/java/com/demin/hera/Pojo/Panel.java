package com.demin.hera.Pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Created by  Domain
 * on 2019/6/11 15:10;
 */
@ToString
@Getter
@Setter
@Entity
@Table(name = "db_panel")
public class Panel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id

    private String panelId;

    private Integer limitNum;

    private String name;

    private String remark;

    private Integer sortOrder;

    private Integer status;

    private Integer type;

    private String itemCatId;

    @Transient
    private List<Item> itemDtoList;
}
