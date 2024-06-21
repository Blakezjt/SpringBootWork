package com.fdzc.javaeeserver.validate.grades;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GradesCreateValidate {

    private static final long serialVersionUID = 1L;

    private Integer studentId;

    private Integer courseId;

    private Integer grade;

    //绩点
    private Double gpa;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime recordTime;
}
