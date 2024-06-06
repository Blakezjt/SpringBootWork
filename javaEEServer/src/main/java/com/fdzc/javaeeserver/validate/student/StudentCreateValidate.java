package com.fdzc.javaeeserver.validate.student;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StudentCreateValidate {

    private static final long serialVersionUID = 1L;

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

    private LocalDateTime entryTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}
