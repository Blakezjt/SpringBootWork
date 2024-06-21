package com.fdzc.javaeeserver.entity.course;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Grades {

    private static final long serialVersionUID = 1L;

    @TableId
    private String id;

    private Integer studentId;

    private Integer courseId;

    private Integer grade;

    //绩点
    private Double gpa;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime recordTime;
}
