package com.mashang.demo.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class T {

    private Integer code;
    private String msg;
    private Object rows;
    private Integer total;

    // rows是当前查询出来的数据集合（分过页的数据）
    // total是当前查询出来的数据不分页的全部条数
    // 比如：查询姓张的学生 第一页，每页5条数
    // 假如一共有10条数据符合姓张的
    // 那么rows就是前五条数据的集合
    // 而total是等于10
    public static T success(Object rows, Integer total) {
        return new T(200, "操作成功", rows, total);
    }

    public static T success(Object rows,String msg, Integer total) {
        return new T(200, msg, rows, total);
    }


    public static T error() {
        return new T(500, "操作失败", null, null);
    }

}
