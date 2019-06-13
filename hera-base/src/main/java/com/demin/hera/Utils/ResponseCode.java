package com.demin.hera.Utils;

/**
 * Created by  Domain
 * on 2019/6/8 18:43;
 */
public enum ResponseCode {
    SUCCESS(200,"SUCCESS"),
    ERROR(0,"ERROR");

    private final int code;
    private final String desc;

    ResponseCode(int code,String desc){
        this.code = code;
        this.desc = desc;
    }
    public int getCode(){
        return code;
    }
    public String getDesc(){
        return desc;
    }

}
