package com.demin.hera.Entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by  Domain
 * on 2019/6/11 14:49;
 */
@Getter
@Setter
@ToString

public class ItemAttributeName implements Serializable {
    private static final long serialVersionUID = 1L;

    private String attributeNameId;

    /**
     * 参数名称
     */
    private String title;

    private String cId;
}
