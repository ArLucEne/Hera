package com.demin.hera.Pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by  Domain
 * on 2019/6/4 10:11;
 */
@Getter
@Setter
@ToString
@Table(name = "db_item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer itemId;
    @Column(name = "item_name")
    private String name;        //商品名称
    @Column(name = "item_category_id")
    private Integer categoryId;     //所属商品种类id
    @Column(name = "item_price")
    private BigDecimal price;       //价格
    @Column(name = "item_num")
    private int num;        //商品库存
    @Column(name = "limited_num")
    private int limitedNum;     //每次限制购买数量
    private int status;     //状态
    @Column(name = "item_point")
    private String point;       //商品卖点
    @Column(name = "item_desc")
    private String desc;        //商品描述
    private int deleteStatus;       //是否已被删除
    @Column(name = "item_image_addr")
    private String imageAddr;        //图片地址
    @Column(name = "item_sale_num")
    private int saleNum;            //销量
    @Column(name = "item_sort_order")
    private int sortOrder;      //排序号码
}