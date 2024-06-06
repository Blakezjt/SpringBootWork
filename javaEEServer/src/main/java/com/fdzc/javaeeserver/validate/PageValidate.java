package com.fdzc.javaeeserver.validate;

import lombok.Data;

@Data
public class PageValidate {

    private static final long serialVersionUID = 1L;

    // 当前分页
    public Integer pageNo;

    // 每页条数
    private Integer pageSize;
}
