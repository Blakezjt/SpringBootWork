package com.fdzc.javaeeserver.validate.student;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StudentUpdateValidate {

    private static final long serialVersionUID = 1L;

    private Integer studentId;

    //系别
    private String studentXb;

    //专业
    private String studentDept;

    private Integer dormitoryId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}
