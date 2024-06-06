package com.fdzc.javaeeserver.vo.student;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StudentDetailVo {

    private static final long serialVersionUID = 1L;

    private Integer studentId;

    private String studentName;

    private Integer studentSex;

    //系别
    private String studentXb;

    //专业
    private String studentDept;

    private Integer dormitoryId;

    private String studentPhone;

    private LocalDateTime entryTime;
}
