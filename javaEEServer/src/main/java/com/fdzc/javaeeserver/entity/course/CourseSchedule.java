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
public class CourseSchedule {
    private static final long serialVersionUID = 1L;

    @TableId
    private String id;

    private Integer courseId;

    private Integer teacherId;

    private Integer classroomId;

    private String courseName;

    //星期
    private String date;

    //时间段
    private String time;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

}
