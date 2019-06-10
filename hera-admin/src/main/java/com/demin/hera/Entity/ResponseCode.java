package com.demin.hera.Entity;

/**
 * Created by  Domain
 * on 2019/6/10 12:45;
 */
public enum ResponseCode {
        SUCCESS(0,"SUCCESS"),
        ERROR(1,"ERROR");

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


