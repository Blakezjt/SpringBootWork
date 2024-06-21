package com.fdzc.javaeeserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fdzc.javaeeserver.common.T;
import com.fdzc.javaeeserver.entity.Student;
import com.fdzc.javaeeserver.entity.Teachers;
import com.fdzc.javaeeserver.entity.course.CourseSchedule;
import com.fdzc.javaeeserver.mapper.CourseScheduleMapper;
import com.fdzc.javaeeserver.service.CourseScheduleService;
import com.fdzc.javaeeserver.validate.CourseSchedule.CourseCreateValidate;
import com.fdzc.javaeeserver.validate.CourseSchedule.CourseSearchValidate;
import com.fdzc.javaeeserver.validate.CourseSchedule.CourseUpdateValidate;
import com.fdzc.javaeeserver.validate.PageValidate;
import com.fdzc.javaeeserver.vo.Course.CourseDetailVo;
import com.fdzc.javaeeserver.vo.Course.CourseListVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Service
public class CourseScheduleServiceImpl implements CourseScheduleService {

    @Resource
    private CourseScheduleMapper courseScheduleMapper;

    @Override
    public T courseList(PageValidate pageValidate, CourseSearchValidate CourseSearchValidate) {
        Integer pageNo = pageValidate.getPageNo();
        Integer pageSize = pageValidate.getPageSize();

        QueryWrapper<CourseSchedule> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("course_id");
        
        Page<CourseSchedule> CoursePage = courseScheduleMapper.selectPage(new Page<>(pageNo, pageSize), queryWrapper);

        List<CourseListVo> list = new LinkedList<>();
        for (CourseSchedule course: CoursePage.getRecords()) {
            CourseListVo vo = new CourseListVo();
            BeanUtils.copyProperties(course,vo);
            list.add(vo);
        }


        return T.success(list, (int) CoursePage.getTotal());
    }

    @Override
    public CourseDetailVo courseDetail(Integer Id) {
        CourseSchedule course = courseScheduleMapper.selectOne(new QueryWrapper<CourseSchedule>()
                .eq("course_id", Id)
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
        courseSchedule.setId(UUID.randomUUID().toString());
        courseSchedule.setTeacherId(createValidate.getTeacherId());
        QueryWrapper<CourseSchedule> QueryWrapper = new QueryWrapper<CourseSchedule>().orderByDesc("course_id");
        CourseSchedule courseSchedule1 = courseScheduleMapper.selectOne(QueryWrapper.last("limit 1"));
        Integer courseScheduleId = courseSchedule1.getCourseId();
        courseSchedule.setCourseId(courseScheduleId + 1);
        courseSchedule.setClassroomId(createValidate.getClassroomId());
        System.out.println(createValidate.getCourseName());
        courseSchedule.setCourseName(createValidate.getCourseName());
        courseSchedule.setDate(createValidate.getDate());
        courseSchedule.setTime(createValidate.getTime());
        courseSchedule.setCreateTime(LocalDateTime.now());
        courseSchedule.setUpdateTime(LocalDateTime.now());
        courseScheduleMapper.insert(courseSchedule);
    }

    @Override
    public void courseDelete(Integer Id) {
        CourseSchedule courseSchedule = courseScheduleMapper.selectOne(new QueryWrapper<CourseSchedule>()
                .eq("course_id", Id));
        courseScheduleMapper.deleteById(courseSchedule);
    }
}
