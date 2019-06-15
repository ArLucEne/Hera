package com.demin.hera.Pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by  Domain
 * on 2019/6/4 10:11;
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "db_item")

public class Item implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String itemId;

    /**
     * 商品名称
     */

    private String name;

    /**
     * 卖点
     */

    private String sellPoint;


    private BigDecimal price;

    /**
     * 库存
     */

    private Integer num;

    /**
     * 限制售卖的数量
     */

    private Integer limitNum;

    /**
     * 商品图片
     */

    private String image;

    /**
     * 分类id
     */

    private String cId;

    private String itemCatName;

    /**
     * 状态
     */
    @Column(columnDefinition = "int default 1")
    private Integer status;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    /**
     * 排序号码
     */
    private Integer sortOrder;

    /**
     * 备注
     */
    private String remark;

    /**
     * 描述
     */
    private String description;

    /**
     * 销量
     */
    private Integer sale;
}
