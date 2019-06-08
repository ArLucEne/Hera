package com.demin.hera.Utils;

import java.lang.reflect.Field;

/**
 * 用于JPA更新
 * 将新对象的非空属性值更新到旧对象
 * Created by  Domain
 * on 2019/6/8 19:15;
 */
public class updateEntity {
    /**
     * 将origin属性复制到destination
     * @param origin
     * @param destination
     */
    public static void update(Object origin,Object destination){
        if (origin == null || destination == null)
            return;
        //同类型对象
        if (!origin.getClass().equals(destination.getClass()))
            return;

        Field[] fields = origin.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            try {
                fields[i].setAccessible(true);
                Object value = fields[i].get(origin);
                if (null != value) {
                    fields[i].set(destination, value);
                }
                fields[i].setAccessible(false);
            } catch (Exception e) {
            }
        }

    }
}
