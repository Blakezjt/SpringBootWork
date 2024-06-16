package com.fdzc.javaeeserver.vo.teacher;

import lombok.Data;

import java.util.Date;

@Data
public class TeacherListVo {

    private static final long serialVersionUID = 1L;

    private String id;

    private Integer teacher_id;

    private String name;

    private Integer sex;

    private Date birthDate;

    private String email;

    private String phone;

    private String address;

    //入职时间
    private Date hireDate;

    private Integer salary;

    private String degree;

    private String major;
}
