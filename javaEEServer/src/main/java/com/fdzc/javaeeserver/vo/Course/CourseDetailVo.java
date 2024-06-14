package com.fdzc.javaeeserver.vo.Course;

import lombok.Data;

@Data
public class CourseDetailVo {

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
