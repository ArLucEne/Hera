package com.demin.hera.Pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

/**
 * Created by  Domain
 * on 2019/6/11 15:08;
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "db_item_attribute_value" )
public class ItemAttributeValue implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String attributeValueId;

    /**
     * 关联商品参数表
     */
    private Long attributeNameId;

    private String attributeValue;

    public ItemAttributeValue(){
        this.attributeValueId = UUID.randomUUID().toString().replace("-","");
    }
}
