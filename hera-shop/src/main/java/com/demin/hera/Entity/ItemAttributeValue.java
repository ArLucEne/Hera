package com.demin.hera.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by  Domain
 * on 2019/6/11 15:08;
 */
@Getter
@Setter
@ToString

public class ItemAttributeValue implements Serializable {
    private static final long serialVersionUID = 1L;

    private String attributeValueId;

    /**
     * 关联商品参数表
     */
    private String attributeNameId;

    private String attributeValue;
}
