package com.fdzc.javaeeserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Borrow {

    private Integer borrowingId;
    private String studentId;
    private String bookId;
    private Date borrowData;
    private Date returnData;

}
