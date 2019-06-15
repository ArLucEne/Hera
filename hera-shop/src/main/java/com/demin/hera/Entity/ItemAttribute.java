package com.demin.hera.Entity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by  Domain
 * on 2019/6/12 9:43;
 */
public class ItemAttribute {
    private List<Map<String,String>> attributes;
    private BigDecimal price;

    public List<Map<String, String>> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Map<String, String>> attributes) {
        this.attributes = attributes;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
