package com.fdzc.javaeeserver.controller;

import com.fdzc.javaeeserver.common.R;
import com.fdzc.javaeeserver.service.impl.TeacherServiceImpl;
import com.fdzc.javaeeserver.validate.PageValidate;
import com.fdzc.javaeeserver.validate.teacher.TeacherCreateValidate;
import com.fdzc.javaeeserver.validate.teacher.TeacherSearchValidate;
import com.fdzc.javaeeserver.validate.teacher.TeacherUpdateValidate;
import com.fdzc.javaeeserver.vo.teacher.TeacherDetailVo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class TeacherController {

    @Resource
    private TeacherServiceImpl teacherService;

    @GetMapping("/list")
    public R teacherList(@Validated PageValidate pageValidate,
                         @Validated TeacherSearchValidate teacherSearchValidate){

        return R.success(teacherService.teacherList(pageValidate,teacherSearchValidate));
    }

    @GetMapping("/detail")
    public R teacherDetail(@Validated @RequestParam("id") Integer teacherId){
        TeacherDetailVo teacherDetailVo = teacherService.teacherDetail(teacherId);
        return R.success(teacherDetailVo);
    }

    @PostMapping("/edit")
    public R teacherEdit(@Validated @RequestBody TeacherUpdateValidate updateValidate){
        teacherService.teacherEdit(updateValidate);
        return R.success();
    }

    @PostMapping("/add")
    public R teacherAdd(@Validated @RequestBody TeacherCreateValidate createValidate){
        teacherService.teacherAdd(createValidate);
        return R.success();
    }

    @DeleteMapping("/delete")
    public R teacherDelete(@Validated @RequestParam("id") Integer teacherId){
        teacherService.teacherDelete(teacherId);
        return R.success();
    }
}
