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
 * on 2019/6/11 15:12;
 */
@Setter
@Getter
@ToString
@Entity
@Table(name = "db_panel_content")
public class PanelContent implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String panelContentId;

    private LocalDateTime createDate;

    private String panelId;

    private String picUrl;

    private String itemId;

    @Column(columnDefinition = "int default 0")
    private Integer sortOrder;

    private LocalDateTime modifyDate;

    public PanelContent(){
        this.panelContentId = UUID.randomUUID().toString().replace("-","");
    }
}