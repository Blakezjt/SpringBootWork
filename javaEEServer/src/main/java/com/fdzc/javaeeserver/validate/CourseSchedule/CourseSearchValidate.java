package com.fdzc.javaeeserver.validate.CourseSchedule;

import lombok.Data;

@Data
public class CourseSearchValidate {

    private static final long serialVersionUID = 1L;

    private Integer courseId;

    private Integer teacherId;

    private Integer classroomId;

    private String courseName;

    //星期
    private String date;

    //时间段
    private String time;
}
