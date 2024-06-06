package com.fdzc.javaeeserver.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Student {

    private static final long serialVersionUID = 1L;

    @TableId
    private Integer studentId;

    private String password;

    private String studentName;

    private Integer studentSex;

    //系别
    private String studentXb;

    //专业
    private String studentDept;

    private Integer dormitoryId;

    private String studentPhone;

    private Integer isDelete;

    private LocalDateTime entryTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime deleteTime;
}
