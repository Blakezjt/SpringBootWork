package com.fdzc.javaeeserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Borrowing {

    @TableId("borrowing_id")
    private Integer borrowingId;
    private String studentId;
    private String bookId;
    private Date borrowData;
    private Date returnData;

}
