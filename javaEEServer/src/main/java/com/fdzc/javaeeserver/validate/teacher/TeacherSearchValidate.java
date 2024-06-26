package com.fdzc.javaeeserver.validate.teacher;

import lombok.Data;

@Data
public class TeacherSearchValidate {

    private static final long serialVersionUID = 1L;

    private Integer teacherId;

    private String name;

    private String degree;

    private String major;
}
