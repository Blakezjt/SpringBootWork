package com.fdzc.javaeeserver.vo.Exams;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExamsListVo {

    private static final long serialVersionUID = 1L;

    private Integer examId;

    private Integer courseId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime examTime;

    private String examLocation;

    private float examHour;
}
