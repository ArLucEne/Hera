package com.demin.hera.Pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
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
    @Column(name = "item_name")
    private String name;        //商品名称
    @Column(name = "item_category_id")
    private String categoryId;     //所属商品种类id
    @Column(name = "item_price")
    private BigDecimal price;       //价格
    @Column(name = "item_num")
    private int num;        //商品库存
    @Column(name = "limited_num")
    private int limitedNum;     //每次限制购买数量
    @Column(columnDefinition = "int default 0")
    private int status;     //状态
    @Column(name = "item_point")
    private String point;       //商品卖点
    @Column(name = "item_desc")
    private String desc;        //商品描述
    @Column(columnDefinition = "int default 0")
    private int deleteStatus;       //是否已被删除
    @Column(name = "item_image_addr")
    private String imageAddr;        //图片地址
    @Column(name = "item_sale_num", columnDefinition = "int default 0")
    private int saleNum;            //销量
    @Column(name = "item_sort_order",columnDefinition = "int default 0")
    private int sortOrder;      //排序号码


    public Item(){
        this.itemId = UUID.randomUUID().toString().replace("-","");
    }

    public static Item getTestEntity(){
        Item test = new Item();
        test.setCategoryId("test");
        test.setName("testCategory");

        test.setPoint("testPoint");
        test.setPrice(new BigDecimal(3.2));
        test.setImageAddr("testUrl");
        test.setNum(5000);
        test.setLimitedNum(4);
        test.setSaleNum(234);
        return  test;
    }
}
