package com.fdzc.javaeeserver.controller.course;

import com.fdzc.javaeeserver.common.R;
import com.fdzc.javaeeserver.service.impl.CourseScheduleServiceImpl;
import com.fdzc.javaeeserver.validate.CourseSchedule.CourseCreateValidate;
import com.fdzc.javaeeserver.validate.CourseSchedule.CourseSearchValidate;
import com.fdzc.javaeeserver.validate.CourseSchedule.CourseUpdateValidate;
import com.fdzc.javaeeserver.validate.PageValidate;
import com.fdzc.javaeeserver.vo.Course.CourseDetailVo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("courseSchedule")
public class CourseScheduleController {

    @Resource
    private CourseScheduleServiceImpl courseScheduleServiceImpl;

    @GetMapping("/list")
    public R courseScheduleList(@Validated PageValidate pageValidate,
                         @Validated CourseSearchValidate courseSearchValidate){

        return R.success(courseScheduleServiceImpl.courseList(pageValidate,courseSearchValidate));
    }


    @GetMapping("/detail")
    public R courseDetail(@Validated @RequestParam("id") Integer courseId){
        CourseDetailVo courseDetailVo = courseScheduleServiceImpl.courseDetail(courseId);
        return R.success(courseDetailVo);
    }
    @PostMapping("/edit")
    public R courseEdit(@Validated @RequestBody CourseUpdateValidate updateValidate){
        courseScheduleServiceImpl.courseEdit(updateValidate);
        return R.success();
    }

    @PostMapping("/add")
    public R courseAdd(@Validated @RequestBody CourseCreateValidate createValidate){
        courseScheduleServiceImpl.courseAdd(createValidate);
        return R.success();
    }

    @DeleteMapping("/delete")
    public R courseDelete(@Validated @RequestParam("id") Integer courseId){
        courseScheduleServiceImpl.courseDelete(courseId);
        return R.success();
    }

}
