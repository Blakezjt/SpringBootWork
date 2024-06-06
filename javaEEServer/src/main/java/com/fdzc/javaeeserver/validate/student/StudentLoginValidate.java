package com.fdzc.javaeeserver.validate.student;

import lombok.Data;

@Data
public class StudentLoginValidate {

    private static final long serialVersionUID = 1L;

    private String studentId;

    private String password;
}
