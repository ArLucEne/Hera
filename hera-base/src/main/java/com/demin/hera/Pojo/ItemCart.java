package com.demin.hera.Pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by  Domain
 * on 2019/6/4 10:55;
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "db_item_cart")
public class ItemCart implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String cartId;
    private String customerId;
    private String customerName;

    private String itemId;     //商品id
    @Column(columnDefinition = "int default 0")
    private int itemNum;        //商品数量
    private BigDecimal itemPrice;       //商品价格
    private String itemImage;
    private String itemPoint;
    private String itemName;
    private String itemCategoryId;
    private BigDecimal price;

    private LocalDateTime createTime;
    private LocalDateTime modifyTime;
    private int status;



    public ItemCart(){
        this.cartId = UUID.randomUUID().toString().replace("-","");
    }

    public static ItemCart getTestEntity(){
        ItemCart test = new ItemCart();
        test.setCreateTime(LocalDateTime.now());
        test.setCustomerId("test");
        test.setItemNum(2);
        test.setItemId("test");
        test.setItemPrice(new BigDecimal(346.44));
        test.setModifyTime(LocalDateTime.now());
        return test;
    }
}
