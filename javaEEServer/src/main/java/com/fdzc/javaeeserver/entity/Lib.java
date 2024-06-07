package com.fdzc.javaeeserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lib {

    private Integer bookId;
    private String title;
    private String author;
    private String isbn;
    private Integer quantity;

}
