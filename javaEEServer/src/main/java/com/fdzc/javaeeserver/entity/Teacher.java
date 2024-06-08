package com.fdzc.javaeeserver.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Teacher {

    private static final long serialVersionUID = 1L;

    @TableId
    private Integer teacher_id;

    private String name;

    private String password;

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

    private Integer isDelete;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime deleteTime;
}
