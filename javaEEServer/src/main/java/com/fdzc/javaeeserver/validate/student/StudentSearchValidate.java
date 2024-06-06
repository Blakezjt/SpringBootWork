package com.fdzc.javaeeserver.validate.student;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StudentSearchValidate {

    private static final long serialVersionUID = 1L;

    private Integer studentId;

    private String studentName;
    //系别
    private String studentXb;

    //专业
    private String studentDept;

    private Integer dormitoryId;
}
