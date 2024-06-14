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
public class Exams {

    private static final long serialVersionUID = 1L;

    @TableId
    private Integer id;

    private Integer examId;

    private Integer courseId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime examTime;

    private String examLocation;
}