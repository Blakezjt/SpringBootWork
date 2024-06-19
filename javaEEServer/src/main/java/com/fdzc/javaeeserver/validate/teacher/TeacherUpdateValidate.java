package com.fdzc.javaeeserver.validate.teacher;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TeacherUpdateValidate {

    private static final long serialVersionUID = 1L;

    private Integer teacherId;

    private String email;

    private String phone;

    private String address;

    private Integer salary;

    private String degree;

    private String major;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}
