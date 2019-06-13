package com.demin.hera.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


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

public class PanelContent implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer panelContentId;

    private LocalDateTime createDate;

    private Integer panelId;

    private String picUrl;

    private String productId;

    private Integer sortOrder;

    private LocalDateTime modifyDate;
}
