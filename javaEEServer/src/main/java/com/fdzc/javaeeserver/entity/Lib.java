package com.fdzc.javaeeserver.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("bookinventory")
public class Lib {

    @TableId("book_id")
    private Integer bookId;
    private String title;
    private String author;
    private String isbn;
    private Integer quantity;

}
