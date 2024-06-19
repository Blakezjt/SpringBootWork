package com.fdzc.javaeeserver.service;

import com.fdzc.javaeeserver.common.T;
import com.fdzc.javaeeserver.validate.CourseSchedule.CourseCreateValidate;
import com.fdzc.javaeeserver.validate.CourseSchedule.CourseSearchValidate;
import com.fdzc.javaeeserver.validate.CourseSchedule.CourseUpdateValidate;
import com.fdzc.javaeeserver.validate.PageValidate;
import com.fdzc.javaeeserver.vo.Course.CourseDetailVo;


public interface CourseScheduleService {

    T  courseList(PageValidate pageValidate,  CourseSearchValidate CourseSearchValidate);

    CourseDetailVo courseDetail(Integer Id);

    void courseEdit( CourseUpdateValidate courseUpdateValidate);

    void courseAdd( CourseCreateValidate createValidate);

    void courseDelete(Integer Id);
}
