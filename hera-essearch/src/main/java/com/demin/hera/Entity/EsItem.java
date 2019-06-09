package com.demin.hera.Entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;



import java.io.Serializable;
import java.math.BigDecimal;

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
    private String name;        //商品名称
    private String categoryId;     //所属商品种类id
    private BigDecimal price;       //价格
    private int num;        //商品库存
    private int limitedNum;     //每次限制购买数量
    private int status;     //状态
    private String point;       //商品卖点
    private String desc;        //商品描述
    private int deleteStatus;       //是否已被删除
    private String imageAddr;        //图片地址
    private int saleNum;            //销量
    private int sortOrder;      //排序号码

}
