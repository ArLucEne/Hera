package com.demin.hera.Pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cartId;
    private Integer customerId;
    private Integer itemId;     //商品id
    private int itemNum;        //商品数量
    private BigDecimal itemPrice;       //商品价格
    private LocalDateTime createTime;
    private LocalDateTime modifyTime;

    public static ItemCart getTestEntity(){
        ItemCart test = new ItemCart();
        test.setCreateTime(LocalDateTime.now());
        test.setCustomerId(2);
        test.setItemNum(2);
        test.setItemId(1);
        test.setItemPrice(new BigDecimal(346.44));
        test.setModifyTime(LocalDateTime.now());
        return test;
    }
}
