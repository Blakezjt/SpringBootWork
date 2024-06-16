package com.fdzc.javaeeserver.validate.CourseSelection;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CourseSelectSearchValidate {

    private static final long serialVersionUID = 1L;

    private String id;

    private Integer studentId;

    private Integer courseId;

    private Integer isSelect;
}
