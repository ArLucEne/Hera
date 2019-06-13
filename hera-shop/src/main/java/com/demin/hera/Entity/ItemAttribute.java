package com.demin.hera.Entity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by  Domain
 * on 2019/6/12 9:43;
 */
public class ItemAttribute {
    private List<Map<Long,Long>> attributes;
    private BigDecimal price;

    public List<Map<Long, Long>> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Map<Long, Long>> attributes) {
        this.attributes = attributes;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
