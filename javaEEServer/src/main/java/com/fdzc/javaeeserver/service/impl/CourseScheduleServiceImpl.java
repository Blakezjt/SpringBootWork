package com.fdzc.javaeeserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fdzc.javaeeserver.common.T;
import com.fdzc.javaeeserver.entity.Student;
import com.fdzc.javaeeserver.entity.course.CourseSchedule;
import com.fdzc.javaeeserver.mapper.CourseScheduleMapper;
import com.fdzc.javaeeserver.service.CourseScheduleService;
import com.fdzc.javaeeserver.validate.CourseSchedule.CourseCreateValidate;
import com.fdzc.javaeeserver.validate.CourseSchedule.CourseSearchValidate;
import com.fdzc.javaeeserver.validate.CourseSchedule.CourseUpdateValidate;
import com.fdzc.javaeeserver.validate.PageValidate;
import com.fdzc.javaeeserver.vo.Course.CourseDetailVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Service
public class CourseScheduleServiceImpl implements CourseScheduleService {

    @Resource
    private CourseScheduleMapper courseScheduleMapper;

    @Override
    public T CourseList(PageValidate pageValidate, CourseSearchValidate CourseSearchValidate) {

        return null;
    }

    @Override
    public CourseDetailVo courseDetail(Integer Id) {
        CourseSchedule course = courseScheduleMapper.selectOne(new QueryWrapper<CourseSchedule>()
                .eq("id", Id)
                .last("limit 1"));
        CourseDetailVo courseDetailVo = new CourseDetailVo();
        BeanUtils.copyProperties(course,courseDetailVo);
        return courseDetailVo;
    }

    @Override
    public void courseEdit(CourseUpdateValidate courseUpdateValidate) {
        CourseSchedule course = courseScheduleMapper.selectOne(new QueryWrapper<CourseSchedule>()
                .eq("course_id", courseUpdateValidate.getCourseId())
                .last("limit 1"));
        course.setTeacherId(courseUpdateValidate.getTeacherId());
        course.setCourseName(courseUpdateValidate.getCourseName());
        course.setClassroomId(courseUpdateValidate.getClassroomId());
        course.setDate(courseUpdateValidate.getDate());
        course.setTime(courseUpdateValidate.getTime());
        course.setUpdateTime(LocalDateTime.now());
        courseScheduleMapper.updateById(course);
    }

    @Override
    public void courseAdd(CourseCreateValidate createValidate) {
        CourseSchedule courseSchedule = new CourseSchedule();
        courseSchedule.setTeacherId(createValidate.getTeacherId());
        courseSchedule.setCourseId(courseSchedule.getCourseId());
        courseSchedule.setCourseName(courseSchedule.getCourseName());
    }

    @Override
    public void courseDelete(Integer Id) {
        CourseSchedule courseSchedule = courseScheduleMapper.selectOne(new QueryWrapper<CourseSchedule>()
                .eq("course_id", Id));
        courseScheduleMapper.deleteById(courseSchedule);
    }
}
