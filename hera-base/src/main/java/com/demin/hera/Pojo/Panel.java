package com.demin.hera.Pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
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

    private LocalDateTime createDate;
    @Column(columnDefinition = "int default 0")
    private Integer limitNum;

    private String name;

    private String remark;
    @Column(columnDefinition = "int default 0")
    private Integer sortOrder;
    @Column(columnDefinition = "int default 0")
    private Integer status;
    @Column(columnDefinition = "int default 0")
    private Integer type;

    private LocalDateTime modifyDate;

    private String itemCategoryId;

    public Panel(){
        this.panelId = UUID.randomUUID().toString().replace("-","");
    }
}
