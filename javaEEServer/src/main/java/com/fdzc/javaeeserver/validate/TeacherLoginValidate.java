package com.fdzc.javaeeserver.validate;

import lombok.Data;

@Data
public class TeacherLoginValidate {

    private static final long serialVersionUID = 1L;

    private String teacherId;

    private String password;
}
