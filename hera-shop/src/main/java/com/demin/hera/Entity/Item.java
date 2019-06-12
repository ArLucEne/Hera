package com.demin.hera.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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


public class Item implements Serializable {
    private static final long serialVersionUID = 1L;


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


    public Item(){
        this.itemId = UUID.randomUUID().toString().replace("-","");
    }


}
