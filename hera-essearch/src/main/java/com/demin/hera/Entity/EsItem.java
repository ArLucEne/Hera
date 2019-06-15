package com.demin.hera.Entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;



import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by  Domain
 * on 2019/6/9 16:19;
 */
@Getter
@Setter
@ToString
@Document(indexName = "hera",type = "item")
//indexName索引名称 可以理解为数据库名 必须为小写
//type类型 可以理解为表名
public class EsItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String itemId;

    private String name;

    private String sellPoint;

    private BigDecimal price;

    private Integer num;

    private Integer limitNum;

    private String image;

    private String cId;

    private String itemCatName;

    private Integer status;



    private Integer sortOrder;

    private String remark;

    private String description;

    private Integer sale;
}
