package com.fdzc.javaeeserver.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class R {

    private Integer code;
    private String msg;
    private Object data;


    public static R success(Object data) {
        return new R(200, "操作成功", data);
    }

    public static R success(Object data,String msg) {
        return new R(200, msg, data);
    }

    public static  R success() {
        return new R(200, "操作成功", null);
    }

    public static R error() {
        return new R(500, "操作失败", null);
    }

    public static R error(Object data,String msg) {
        return new R(500, msg, data);
    }
    public static R to(int result) {
        if (result > 0) {
            return R.success();
        } else {
            return R.error();
        }
    }
    public static R to(Boolean result) {
        if (result) {
            return R.success();
        } else {
            return R.error();
        }
    }

}
