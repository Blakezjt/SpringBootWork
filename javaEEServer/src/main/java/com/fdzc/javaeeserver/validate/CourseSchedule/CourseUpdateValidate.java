package com.fdzc.javaeeserver.validate.CourseSchedule;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CourseUpdateValidate {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer courseId;

    private Integer teacherId;

    private Integer classroomId;

    private String courseName;

    //星期
    private String date;

    //时间段
    private String time;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}
