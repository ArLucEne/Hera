package com.demin.hera.Pojo;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

/**
 * Created by  Domain
 * on 2019/6/11 14:49;
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "db_item_attribute_name")
public class ItemAttributeName implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String attributeNameId;

    /**
     * 参数名称
     */
    private String title;

    private String categoryId;

    public ItemAttributeName(){
        this.attributeNameId = UUID.randomUUID().toString().replace("-","");
    }

}
